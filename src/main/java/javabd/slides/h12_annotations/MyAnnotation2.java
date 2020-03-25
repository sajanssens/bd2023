package javabd.slides.h12_annotations;

import java.lang.annotation.*;


// @Documented // Deze annotatie moet NIET getoond worden in de javadoc van het element waar hij op staat:
@Retention(RetentionPolicy.CLASS) // Tot waar wordt deze annotatie meegenomen? SOURCE: alleen in source, niet in gecompileerde class en ook niet at runtime beschikbaar.
@Target(ElementType.METHOD) // deze annotatie mag op een method
public @interface MyAnnotation2 {
    String value() default "Hello2";
}
