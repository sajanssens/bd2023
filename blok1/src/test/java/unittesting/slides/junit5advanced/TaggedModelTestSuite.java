package unittesting.slides.junit5advanced;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.example")
@IncludeTags({"surefire", "model"})
public class TaggedModelTestSuite {

}
