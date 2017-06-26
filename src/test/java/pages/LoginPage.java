package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage
{
    public static final String HOME_PAGE_URL="https://mail.ukr.net/";
    public static final By INPUT_PASSWORD=By.xpath(".//*[@id='password']");
    public static final By INPUT_LOGIN=By.xpath(".//*[@id='login']");
    public static final By SIGN_IN=By.cssSelector("button[type=\"submit\"]");
    public static final By LOG_OUT =By.xpath(".//a[@href='/q/logout'][@class='panel-link']");


    private WebDriver driver;

    public LoginPage(WebDriver driver)//LoginPage constructor
    {
        this.driver=driver;
    }

    public LoginPage open()
    {

        driver.get(HOME_PAGE_URL);
        return this;//return all page to work
    }
    public void logOut()

    {
        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(LOG_OUT));
        try{
            driver.findElement(LOG_OUT).click();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public EmailPage loginAs(String login, String password)//return page of type LoginPage
    {
        WebDriverWait wait=new WebDriverWait(driver,15);

            wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_LOGIN));
            try {
                driver.findElement(INPUT_LOGIN).sendKeys("");
            driver.findElement(INPUT_LOGIN).sendKeys(login);
            driver.findElement(INPUT_PASSWORD).sendKeys(password);
            driver.findElement(SIGN_IN).click();
        }
        catch (Exception e)
        {
            System.out.println("ss");
        }

        return new EmailPage(driver);


    }






}


