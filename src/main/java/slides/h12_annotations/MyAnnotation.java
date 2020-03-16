package slides.h12_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Documented // Deze annotatie moet getoond worden in de javadoc van het element waar hij op staat:
@Retention(RetentionPolicy.RUNTIME) // Tot waar wordt deze annotatie meegenomen? SOURCE: alleen in source, niet in gecompileerde class.
@Target({ElementType.TYPE, ElementType.METHOD}) // deze annotatie mag op een class en een method
public @interface MyAnnotation {
    String value() default "Hello";

    boolean val();
}