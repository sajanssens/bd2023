package javabd.slides.h12_annotations;

@MyAnnotation(value = "World", val = false)
// @MyAnnotation2 mag hier niet, alleen op methods
public class MyAnnotatedClass {

    // @MyAnnotation mag hier niet, alleen op classes en methods
    private String field1;

    @MyAnnotation(val = true, value = "X")
    @MyAnnotation2
    public void someMethod() {
        System.out.println("someMethod is called");
    }

    @MyAnnotation2
    public void someOtherMethod() {
        System.out.println("someOtherMethod is called");
    }

    @MyAnnotation(val = true)
    public void myAnnotationAnnotatedMethod() {

    }

}
