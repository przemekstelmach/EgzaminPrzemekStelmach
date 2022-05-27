package CodersLabExams;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class Zadanie_2 {

    public static void main(String[] args) throws InterruptedException, IOException

    {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

            WebElement MyStoreSightIn = driver.findElement(By.cssSelector("a[title='Log in to your customer account'] span[class='hidden-sm-down']"));
            MyStoreSightIn.click();

            WebElement EmailLogin = driver.findElement(By.xpath("//input[@class='form-control']"));
            EmailLogin.clear();
            EmailLogin.sendKeys("boesdworgcgzipspks@kvhrr.com");

            WebElement PasswordPutIn = driver.findElement(By.xpath("//input[@name='password']"));
            PasswordPutIn.clear();
            PasswordPutIn.sendKeys("coderslab");

            WebElement SignInButton = driver.findElement(By.xpath("//button[@id='submit-login']"));
            SignInButton.submit();

            WebElement MyStoreButton = driver.findElement(By.xpath("//img[@alt='PrestaShop']"));
            MyStoreButton.click();

            WebElement HummingbirdPrintedSweaterButton = driver.findElement(By.xpath("//img[@alt='Brown bear printed sweater']"));
            HummingbirdPrintedSweaterButton.click();

            Select SizeMSelect = new Select(driver.findElement(By.name("group[1]")));
            SizeMSelect.selectByValue("2");

            WebElement QuantityButton = driver.findElement(By.id("quantity_wanted"));
            QuantityButton.clear();
            driver.findElement(By.id("quantity_wanted")).sendKeys("5");

            WebElement AddToCartButton = driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']"));
            AddToCartButton.click();

            Thread.sleep(1000);
            driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();

            driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();

            WebElement ConfirmButton = driver.findElement(By.xpath("//button[@name='confirm-addresses']"));
            ConfirmButton.click();

            driver.findElement(By.xpath("//div[@class='delivery-options']//div[1]//div[1]//span[1]//span[1]")).click();

            WebElement PickUpButton = driver.findElement(By.xpath("//button[@name='confirmDeliveryOption']"));
            PickUpButton.click();

            driver.findElement(By.xpath("//input[@id='payment-option-1']")).click();
            driver.findElement(By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']")).click();

            WebElement FinalButton = driver.findElement(By.cssSelector("button[class='btn btn-primary center-block']"));
            FinalButton.click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/test/screenshot/screenshot.png"));
    }
}