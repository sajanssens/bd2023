package javabd.slides.h12_annotations;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class MyAnnotatedClassTest {

    @Test
    void whenAMethodIsAnnotatedWithMyAnnotationThenDefaultValueIsCorrect() {
        Method[] declaredMethods = MyAnnotatedClass.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals("someOtherMethod2")) {
                MyAnnotation annotation = declaredMethod.getAnnotation(MyAnnotation.class);
                String defaultValue = annotation.value();
                assertThat(defaultValue).contains("Hello");
            }
        }
    }

}