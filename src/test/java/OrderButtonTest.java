import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum_services.qa_scooter.HopePage;
import ru.praktikum_services.qa_scooter.order.PageOrder;

import static org.junit.Assert.assertEquals;

public class OrderButtonTest {
    private WebDriver driver;
    private String expectedResult = "Для кого самокат";
    private String actualResult;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkOrderUpButton(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HopePage hopePage = new HopePage(driver);
        hopePage.clickOrderUpButton();
        PageOrder pageOrder = new PageOrder(driver);
        actualResult = pageOrder.getOrderHeaderText();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkOrderDownButton(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HopePage hopePage = new HopePage(driver);
        hopePage.clickOrderDownButton();
        PageOrder pageOrder = new PageOrder(driver);
        actualResult = pageOrder.getOrderHeaderText();
        assertEquals(expectedResult, actualResult);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
