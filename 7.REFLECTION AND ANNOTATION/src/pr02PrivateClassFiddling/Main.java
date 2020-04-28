package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		Scanner scanner = new Scanner(System.in);
		Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		BlackBoxInt blackBoxInt = constructor.newInstance();
		Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
		Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
		String input = scanner.nextLine();
		innerValue.setAccessible(true);
		while (!input.equals("END")){
			String methodName = input.split("_")[0];
			int value = Integer.parseInt(input.split("_")[1]);
			Method method = Arrays.stream(methods)
					.filter(m->m.getName().equals(methodName))
					.findFirst().orElse(null);
			method.setAccessible(true);
			method.invoke(blackBoxInt, value);
			System.out.println(innerValue.get(blackBoxInt));

			input = scanner.nextLine();
		}

	}
}
