package ua.nure.testing;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Stanislav_Vorozhka
 */
public class AutomatedWikiTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void findRegexpWikiPage() {
        driver.get("https://www.wikipedia.org/");
        assertEquals("Wikipedia", driver.getTitle());

        driver.findElement(By.id("searchInput")).sendKeys("regexp");
        driver.findElement(By.className("pure-button-primary-progressive")).click();
        assertEquals("Regular expression - Wikipedia", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
