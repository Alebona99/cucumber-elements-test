package com.elements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsPage {

    private static final String SITE = "https://demoqa.com/elements";
    private static final String WEBDRIVER_CHROME_NAME = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_PATH = "/usr/bin/chromedriver";
    protected WebDriver driver;

    @Given("the page elements is opened")
    public void thePageElementsIsOpened(){
        driver.get(SITE);
    }

    @When("user click on Elements button")
    public void userClickOnElementsButton() {
        ElementsPageElements mainPage = new ElementsPageElements(driver);
        mainPage.buttonElements.click();
    }

    @Then("should see list of elements")
    public void shouldSeeListOfElements() {
        ElementsPageElements mainPage = new ElementsPageElements(driver);
        Assertions.assertTrue( mainPage.elementsButtons.getText().contains("Buttons"));
    }

    @Given("user click on TextBox button")
    public void userClickOnTextBoxButton() {
        ElementsPageElements mainPage = new ElementsPageElements(driver);
        mainPage.textBox.click();
    }

    @When("complete the form")
    public void completeTheForm() {
        ElementsPageElements mainPage = new ElementsPageElements(driver);
        mainPage.usernameBox.sendKeys("Alessio Bonanno");
        mainPage.userEmail.sendKeys("alexiobona99@gmail.com");
        mainPage.currentAddress.sendKeys("Via staffetta 181");
        mainPage.permanentAddress.sendKeys("Via staffetta 181");
    }

    @And("click Submit button")
    public void clickSubmitButton() {
        ElementsPageElements mainPage = new ElementsPageElements(driver);
        Actions action = new Actions(driver);
        action.moveToElement(mainPage.submitButton).click().build().perform();
    }


    @Then("the user see the entered data")
    public void theUserSeeTheEnteredData() throws InterruptedException{
        ElementsPageElements mainPage  =new ElementsPageElements(driver);
        Thread.sleep(2000);
        Assertions.assertTrue(mainPage.nameParagraph.isDisplayed());
        Assertions.assertTrue(mainPage.nameParagraph.getText().equals("Name:Alessio Bonanno"));
        Assertions.assertTrue(mainPage.emailParagraph.getText().equals("Email:alexiobona99@gmail.com"));
        Assertions.assertTrue(mainPage.currentAddressParagraph.getText().equals("Current Address :Via staffetta 181"));
        Assertions.assertTrue(mainPage.permanentAddressParagraph.getText().equals("Permananet Address :Via staffetta 181"));
    }

    @Before
    public void beforeScenario() {
        System.setProperty(WEBDRIVER_CHROME_NAME, WEBDRIVER_CHROME_PATH);

        final ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.setCapability("setJavascriptEnabled", "true");

        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void afterScenario() {
        driver.quit();
    }


}
