import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

@Test
public class TaskReportTest {
    private static final String URL = "http://localhost/Task"; //"https://www.pochtabank.ru/feedback";
    private ChromeDriver chrome;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\Projects\\Autotest\\ChromeDriver\\chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Chrome driver Created");
        chrome.register(UsernameAndPassword.of("klementevv", "1qaz@WSX"));
    }

    @BeforeMethod
    public void setUp() {
        chrome.get(URL);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task Report page is open.");
    }

    @Test
    public void TitleTest() {
        String title = chrome.getTitle();
        System.out.println("Task Report Title - " + title);
        Assert.assertEquals(title, "Отчет по задачам", "Правильный заголовок");
        chrome.quit();
        System.out.println("Chrome closed");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test
    public void CloseNotificationTest() {
        WebElement btn = chrome.findElement(By.cssSelector("button.ui-dialog-titlebar-close"));
        String title = btn.getAttribute("title");
        System.out.println("Task Report button Title - " + title);
        chrome.executeScript("$('button.ui-dialog-titlebar-close').click();");
        WebElement dialog = null;
        try {
            dialog = chrome.findElement(By.className("ui-dialog-titlebar"));
        } catch (NoSuchElementException sex) {
            System.out.println(sex.getMessage());
        }
        Assert.assertFalse(dialog.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        chrome.quit();
        System.out.println("Chrome closed");
    }
}
