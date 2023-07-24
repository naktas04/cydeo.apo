package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

    @FindBy(css = "button[aria-label='Einverstanden']")//button[@aria-label="Einverstanden"]
    public WebElement accept_btn;
    @FindBy(id = "holder_left")////img[@title='Online Apotheke apodiscounter.de']
    public WebElement header;
    @FindBy(css = ".shop_logo_header")//"#idOfSearchfield"
    public WebElement search_box;
    @FindBy(id = "//div[@id='web_kit_speech_recognition']") //css = "input[title='Los']")
    public WebElement click_icon;
    @FindBy(id = "//*[@id=\"content_column\"]/div[1]/span")
    public WebElement result;

    public Search() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
