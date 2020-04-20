package javabd.labs.h12_annotations.lab;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({MyClass1Test.class, MyClass2Test.class})
public class MyClassTestSuite {

}