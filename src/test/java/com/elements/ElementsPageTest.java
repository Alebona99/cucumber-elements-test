package com.elements;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:report/elements.html", "json:report/elements-report.json"},
        features ={"src/test/java/features/Elements.feature"})
public class ElementsPageTest {
}
