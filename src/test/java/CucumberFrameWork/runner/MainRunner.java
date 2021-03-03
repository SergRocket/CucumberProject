package CucumberFrameWork.runner;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/CucumberFrameWork/featureFiles"}, glue={"CucumberFrameWork.steps"}, monochrome = true,
        tags={})
public class MainRunner {

}
