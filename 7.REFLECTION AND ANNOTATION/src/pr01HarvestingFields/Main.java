package pr01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {

		RichSoilLand richSoilLand = new RichSoilLand();
		Class richSoilLandClass = richSoilLand.getClass();
		Field[] fields = richSoilLandClass.getDeclaredFields();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Consumer<Field> printer = f-> System.out.println(String.format("%s %s %s",
				Modifier.toString(f.getModifiers()),f.getType().getSimpleName(),f.getName()));
		while (!input.equals("HARVEST")){
			String finalInput = input;
			Field[] requestedFields = Arrays.stream(fields)
					.filter(f->Modifier.toString(f.getModifiers()).equals(finalInput))
					.toArray(Field[]::new);
			if (requestedFields.length!=0){
				Arrays.stream(requestedFields).forEach(printer);
			}else {
				Arrays.stream(fields).forEach(printer);
			}
			input = scanner.nextLine();
		}
	}
}
