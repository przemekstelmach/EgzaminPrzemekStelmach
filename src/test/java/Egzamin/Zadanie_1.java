package CodersLabExams;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



// mail: boesdworgcgzipspks@kvhrr.com
// Mr.
// password: coderslab
// First Name: Przemyslaw
// Last Name: Stelmach
// Birthdate: 06/13/1993
// Windows 11 , Chrome Wersja 102.0.5005.63 (Oficjalna wersja) (64-bitowa)

public class Zadanie_1
{
    public String alias;
    private WebDriver driver;


    @Given("open Chrome browser at MyStore Homepage")
            public void openHomePage ()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When ("user click SightInButton")
        public void logingIn()
    {

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
    }

    @And ("user go to new adresses add page")
    public void adressClick()
    {
       WebElement AdressesButton= By.xpath("//i[contains(text(),'\uE567')]").findElement(driver); // Przejście do podstrony z adresem
       AdressesButton.click();
    }

    @And("user provide his country")

     public void provideUserCountry()
    {
        Select countrySelect = new Select(driver.findElement(By.name("id_country")));
        countrySelect.selectByValue("17");
            }

    @And("^user provide his alias (.*)")
    public void provideUserAlias(String alias)
    {
        WebElement aliasBar = driver.findElement(By.xpath("//input[@name='alias']"));
        aliasBar.clear();
        aliasBar.sendKeys(alias);
        aliasBar.submit();
    }

    @And("^user provide his adress (.*)")
    public void provideUserAdress(String adress)
    {
        WebElement adressBar = driver.findElement(By.xpath("//input[@name='address1']"));
        adressBar.clear();
        adressBar.sendKeys(adress);
        adressBar.submit();
    }

    @And("^user provide his city (.*)")
    public void provideUserCity(String city)
    {
        WebElement cityBar = driver.findElement(By.xpath("//input[@name='city']"));
        cityBar.clear();
        cityBar.sendKeys(city);
    }

    @And("^user provide his postalCode (.*)")
    public void provideUserPostalCode(String postalCode)
    {
        WebElement postalCodeBar = driver.findElement(By.xpath("//input[@name='postcode']"));
        postalCodeBar.clear();
        postalCodeBar.sendKeys(postalCode);
    }


    @And("^user provide his phone (.*)")
    public void provideUserPhone(String phone)
    {
        WebElement phoneBar = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneBar.clear();
        phoneBar.sendKeys(phone);
        phoneBar.submit();
    }

    @Then ("^user is successfully registered as (.*) (.*) (.*) (.*) (.*)")
    public void verifyRegistartion(String expectedAlias, String expectedAdress, String expectedCity, String expectedPostalCode, String expectedPhone)
    {
        String paraText = driver.findElement(By.xpath("//body//main//address[1]")).getText();


        String[] lista = paraText.split("\n");
        System.out.println(lista[0]);
        System.out.println(lista[1]);
        System.out.println(lista[2]);
        System.out.println(lista[3]);
        System.out.println(lista[4]);
        System.out.println(lista[5]);
        Assert.assertEquals(lista[0],"Przemyslaw Stelmach");
        Assert.assertEquals(lista[1],expectedAdress);
        Assert.assertEquals(lista[2],expectedCity);
        Assert.assertEquals(lista[3],expectedPostalCode);
        Assert.assertEquals(lista[5],expectedPhone);

    }

    @And("close browser")
    public void closeBrowser()
    {
        driver.quit();
    }

}

