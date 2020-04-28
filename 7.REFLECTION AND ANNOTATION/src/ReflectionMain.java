import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ReflectionMain {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> clazz = Reflection.class;
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces
        ) {
            System.out.println(anInterface);
        }
        Reflection ref = clazz.getDeclaredConstructor().newInstance();
        System.out.println(ref);
        Method[] declaredmethods = clazz.getDeclaredMethods();

        TreeSet<Method> getterMethods = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> setterMethods = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Field> fieldsModifiers = new TreeSet<>(Comparator.comparing(Field::getName));

        for (Method method : declaredmethods
        ) {
            if (method.getName().startsWith("get")) {
                if (method.getParameterCount() == 0) {
                    int modifiers = method.getModifiers();
                    if (!Modifier.isPublic(modifiers)) {
                        getterMethods.add(method);
                    }
                }
            } else if (method.getName().startsWith("set")) {
                if (method.getParameterCount() == 1) {
                    if (void.class.equals(method.getReturnType())) {
                        int modifiers = method.getModifiers();
                        if (!Modifier.isPrivate(modifiers)) {
                            setterMethods.add(method);
                        }
                    }
                }
            }
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields
        ) {
            int modifiers = field.getModifiers();
            if (!Modifier.isPrivate(modifiers)) {
                fieldsModifiers.add(field);
            }
        }

        fieldsModifiers.forEach(f -> System.out.printf("%s must be private!%n", f.getName()));
        getterMethods.forEach(m -> System.out.printf("%s must be public!%n", m.getName()));
        setterMethods.forEach(m -> System.out.printf("%s must be private!%n", m.getName()));

        @SuppressWarnings("unchecked")
        Method getName = clazz.getDeclaredMethod("getName");
        Annotation[] declaredAnnotations = getName.getDeclaredAnnotations();
        for (Annotation annotation:declaredAnnotations
             ) {
            System.out.println(annotation);
        }

        Author author = getName.getAnnotation(Author.class);
        System.out.println(author.name());
    }
}
