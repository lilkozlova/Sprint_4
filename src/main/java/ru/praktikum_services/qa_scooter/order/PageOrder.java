package ru.praktikum_services.qa_scooter.order;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

public class PageOrder {
    private WebDriver driver;

    private By orderHeaderText = By.xpath("//div[@class='Order_Header__BZXOb']");
    private By editName = By.xpath("(//div[@class='Order_Form__17u6u']//input)[1]");
    private By editSurname = By.xpath("(//div[@class='Order_Form__17u6u']//input)[2]");
    private By editAddress = By.xpath("(//div[@class='Order_Form__17u6u']//input)[3]");
    private By editMetroStation = By.xpath("(//div[@class='Order_Form__17u6u']//input)[4]");
    private By editTelephone = By.xpath("(//div[@class='Order_Form__17u6u']//input)[5]");
    private By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button");
    private By deliveryDate = By.xpath("//div[@class='react-datepicker__input-container']//input");
    private By rentalPeriod = By.xpath("//div[contains(@class, 'Dropdown-control')]//div[contains(text(), '* Срок аренды')]");
    private By checkBoxScooterBlack = By.xpath("//input[@id='black']");
    private By checkBoxScooterGrey = By.xpath("//input[@id='grey']");
    private By editCommentCourier = By.xpath("//div[@class='Input_InputContainer__3NykH']//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private By buttonOrder = By.xpath("(//div[@class='Order_Buttons__1xGrp']/button)[2]");
    private By buttonYes = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By labelOrder = By.cssSelector("div.Order_ModalHeader__3FDaJ");
    public PageOrder(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderHeaderText(){
        return driver.findElement(orderHeaderText).getText();
    }

    public void clickEditName() {
        driver.findElement(editName).click();
    }

    public void fillEditName(String name) {
        driver.findElement(editName).sendKeys(name);
    }

    public void clickEditSurname() {
        driver.findElement(editSurname).click();
    }

    public void fillEditSurname(String surname) {
        driver.findElement(editSurname).sendKeys(surname);
    }

    public void clickEditAddress() {
        driver.findElement(editAddress).click();
    }

    public void fillEditAddress(String address) {
        driver.findElement(editAddress).sendKeys(address);
    }

    public void  clickEditMetroStation(){
        driver.findElement(editMetroStation).click();
    }

    public void clickEditTelephone() {
        driver.findElement(editTelephone).click();
    }
    public void fillEditTelephone(String telephone) {

        driver.findElement(editTelephone).sendKeys(telephone);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    public void clickDeliveryDate() {
        driver.findElement(deliveryDate).click();
    }

    public void fillDeliveryDate(String date) {
        driver.findElement(deliveryDate).sendKeys(date);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void clickRentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }

    public void clickScooterColor(String scooterColor) {
        if (Objects.equals(scooterColor, "black")) {
            driver.findElement(checkBoxScooterBlack).click();
        } else {
            driver.findElement(checkBoxScooterGrey).click();
        }

    }

    public void clickCommentCourier() {
        driver.findElement(editCommentCourier).click();
    }

    public void fillCommentCourier(String comment) {
        driver.findElement(editCommentCourier).sendKeys(comment);
    }

    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    public String getTextLabelOrder(){
        return driver.findElement(labelOrder).getText();
    }


}
