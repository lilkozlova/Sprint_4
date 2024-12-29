package ru.praktikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HopePage {
    private WebDriver driver;

    private By orderUpButton = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private By orderDownButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");

    public HopePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }

    public void clickOrderDownButton() {
        WebElement element = driver.findElement(orderDownButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getOpenTextQuestion(int numberAccordion){
        By textQuestion = By.id("accordion__panel-" + numberAccordion);
        By dropList = By.id("accordion__heading-" + numberAccordion);
        WebElement element = driver.findElement(dropList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        element = driver.findElement(textQuestion);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element.getText();
    }

}
