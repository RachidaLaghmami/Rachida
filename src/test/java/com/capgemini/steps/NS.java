package com.capgemini.steps;

import com.capgemini.ourWebdriver.OurWebDriver;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import com.capgemini.ourWebdriver.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

/**
 * Created by DLAMMERS on 19/4/2016.
 */
public class NS {
    private OurWebDriver browser;

    public NS() throws MalformedURLException {
        this.browser = BrowserFactory.getWebDriver();

    }

    @Given("^I am at www\\.ns\\.nl$")
    public void iAmAtWwwNsNl() throws Throwable {
        browser.get("https://www.ns.nl/producten/en/s/enkele-reis");
    }

    @And("^I clicked accept in cookie popup$")
    public void iClickedAcceptInCookiePopup() throws Throwable {
        WebElement iframe = browser.findElement(By.cssSelector(".r42CookieBar"));
        browser.switchTo().frame(iframe);
        browser.findElement(By.cssSelector(".button.accept")).click();
        browser.switchTo().defaultContent();

    }

    @When("^I choose to travel today$")
    public void iChooseToTravelToday() throws Throwable {
        browser.findElement(By.cssSelector("[for=\"Today_TravelDate\"]")).click();
    }


}
