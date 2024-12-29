import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum_services.qa_scooter.HopePage;
import ru.praktikum_services.qa_scooter.order.PageOrder;

import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class CreatingAnOrderTest {
    private final String editName;
    private final String editSurname;
    private final String editAddress;
    private final String editMetroStation;
    private final String editTelephone;
    private final String deliveryDate;
    private final int rentalPeriod;
    private final String scooterColor;
    private final String commentCourier;
    private final String expectedText;
    private final String locationButton;
    private WebDriver driver;
    private String actuallyText;



    public CreatingAnOrderTest(String locationButton, String editName, String editSurname, String editAddress, String editMetroStation,
                               String editTelephone, String deliveryDate, int rentalPeriod, String scooterColor, String commentCourier, String expectedText) {
        this.locationButton = locationButton;
        this.editName = editName;
        this.editSurname = editSurname;
        this.editAddress = editAddress;
        this.editMetroStation = editMetroStation;
        this.editTelephone = editTelephone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
        this.commentCourier = commentCourier;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"UP", "Лилия", "Козлова", "Высоцкого 27", "Сокольники", "89994670120", "30.12.2024", 1, "black", "Подъезд 2", "Заказ оформлен"},
                {"Down", "Иван", "Иванов", "Советская 10", "Лубянка", "89994629709", "31.12.2024", 2, "grey", "Подъезд 1", "Заказ оформлен"}
        };
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkOrder(){
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HopePage hopePage = new HopePage(driver);
        if (Objects.equals(locationButton, "UP")){
            hopePage.clickOrderUpButton();
        } else {
            hopePage.clickOrderDownButton();
        }

        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.clickEditName();
        pageOrder.fillEditName(editName);
        pageOrder.clickEditSurname();
        pageOrder.fillEditSurname(editSurname);
        pageOrder.clickEditAddress();
        pageOrder.fillEditAddress(editAddress);
        pageOrder.clickEditMetroStation();
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/descendant::li//div[contains(text(), '" + editMetroStation + "')]")));;
        element.click();
        pageOrder.clickEditTelephone();
        pageOrder.fillEditTelephone(editTelephone);
        pageOrder.clickNextButton();
        pageOrder.clickDeliveryDate();
        pageOrder.fillDeliveryDate(deliveryDate);
        pageOrder.clickRentalPeriod();
        WebElement rentElement = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Dropdown-menu']//div[" + rentalPeriod +"]")));;
        rentElement.click();
        pageOrder.clickScooterColor(scooterColor);
        pageOrder.clickCommentCourier();
        pageOrder.fillCommentCourier(commentCourier);
        pageOrder.clickButtonOrder();
        pageOrder.clickButtonYes();
        actuallyText = pageOrder.getTextLabelOrder();
        assertEquals(expectedText, actuallyText);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
