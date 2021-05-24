package com.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPageElements {

    @FindBy( xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")
    public WebElement buttonElements;

    /**
     * Element Buttons of the list Elements
     */
    @FindBy(id = "item-4")
    public WebElement elementsButtons;

    /**
     * Text Box button
     */
    @FindBy( xpath = "//*[@id=\"item-0\"]/span")
    public WebElement textBox;


    /**
     * Field of Form TextBox
     */


    @FindBy( id = "userName")
    public WebElement usernameBox;

    @FindBy( id = "userEmail")
    public WebElement userEmail;

    @FindBy( id = "currentAddress")
    public WebElement currentAddress;

    @FindBy( id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy( xpath = "//*[@id=\"submit\"]")
    public WebElement submitButton;


    /**
     * Paragraph end page
     */

    @FindBy( css = "p[id=name]")
    public WebElement nameParagraph;


    @FindBy( css = "p[id=email]")
    public WebElement emailParagraph;

    @FindBy( css = "p[id=currentAddress]")
    public WebElement currentAddressParagraph;

    @FindBy( css = "p[id=permanentAddress]")
    public WebElement permanentAddressParagraph;

    @FindBy( xpath = "//*[@id=\"output\"]/div")
    public WebElement endparagraph;


    public ElementsPageElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
