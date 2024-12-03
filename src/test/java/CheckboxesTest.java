import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void CheckboxesElements() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        System.out.println("The checkbox is selection state is - " + checkbox1.isSelected());
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected();
        checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        System.out.println("The checkbox is selection state is - " + checkbox1.isSelected());
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        System.out.println("The checkbox is selection state is - " + checkbox2.isSelected());
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        System.out.println("The checkbox is selection state is - " + checkbox2.isSelected());
    }
        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }