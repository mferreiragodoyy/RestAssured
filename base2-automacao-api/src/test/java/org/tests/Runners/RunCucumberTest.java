package org.tests.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {},
        features = {"src/test/resources/feature/PetStore"},
        tags = ("@Test1 or @Test2 or @Test3 or @Test4"),
        glue = {"steps.PetStore"}

)
public class RunCucumberTest {


}
