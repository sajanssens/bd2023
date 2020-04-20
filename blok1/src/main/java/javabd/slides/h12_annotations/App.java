package javabd.slides.h12_annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyAnnotatedClass c = new MyAnnotatedClass();

        // print alle annotaties op de class (met rentention RUNTIME dus)
        System.out.println("Class RUNTIME annotations of " + c.getClass().getName());
        for (Annotation annotation : c.getClass().getAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println();

        // print alle annotaties op alle methods van de class (met rentention RUNTIME dus)
        System.out.println("Method RUNTIME annotations of " + c.getClass().getName());
        for (Method method : c.getClass().getDeclaredMethods()) {
            System.out.print(method.getName() + " has annotation: ");
            for (Annotation declaredAnnotation : method.getDeclaredAnnotations()) {
                System.out.println(declaredAnnotation);
                if(declaredAnnotation.annotationType().equals(MyAnnotation.class)){
                    method.invoke(c);
                }
            }
        }

    }

}
