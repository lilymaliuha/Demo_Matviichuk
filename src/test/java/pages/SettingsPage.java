package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class SettingsPage
{

    public static final By FILTERS_LINK=By.xpath(".//a[@href='#settings,tab=filters']");
    public static final By CREATE_FILTER_BUTTON=By.xpath("//input[@name='create']");
    public static final By FROM_FIELD =By.xpath("//*[@name='From']");
    public static final By SUBMIT_FILTER_CREATION =By.cssSelector(".filter-create.button>input");
    public static final By REMOVE_FILTER= By.cssSelector(".settings-filters-remove");
    public static final By CHANGE_PASSWORD_LINK=By.xpath(".//a[@href='#settings,tab=password']");
    public static final By OLD_PSWRD_FIELD=By.xpath("//input[@id='old_pass']");
    public static final By NEW_PSWRD_FIELD=By.xpath("//input[@id='new_pass']");
    public static final By NEW_PSWRD_REPEAT=By.xpath("//input[@id='repass']");
    public static final By NEW_PSWRD_BTN= By.cssSelector(".settings-form-button.button>input");
    public static final By ERRO_PSWRD=By.xpath("//*[@class='settings-error']");

    private WebDriver driver;
    private WebElement filter, err_msg;
    public SettingsPage(WebDriver driver)//SettingsPage constructor
    {
        this.driver=driver;
    }
    public void createFilter(String emailAddres) throws InterruptedException {



        driver.findElement(FILTERS_LINK).click();
        String parentHandle = driver.getWindowHandle();
        driver.findElement(CREATE_FILTER_BUTTON).click();
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }
        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FROM_FIELD));
        try {
            driver.findElement(FROM_FIELD).sendKeys(emailAddres);
            driver.findElement(SUBMIT_FILTER_CREATION).click();
            driver.switchTo().window(parentHandle);

        }
        catch (Exception e){
            System.out.println(e);
        }


    }
    public void deleteFilter() throws InterruptedException {
        filter=driver.findElement(REMOVE_FILTER);
        assertTrue(filter.isDisplayed());
        filter.click();
        Alert alert =driver.switchTo().alert();//Click on browser window
        alert.accept();
        Thread.sleep(3000);


    }
    public void changePassword(String old_pswrd, String new_pswrd, String new_pswrd_repeat)
    {
        driver.findElement(CHANGE_PASSWORD_LINK).click();
        driver.findElement(OLD_PSWRD_FIELD).sendKeys(old_pswrd);
        driver.findElement(NEW_PSWRD_FIELD).sendKeys(new_pswrd);
        driver.findElement(NEW_PSWRD_REPEAT).sendKeys(new_pswrd_repeat);
        driver.findElement(NEW_PSWRD_BTN).click();
        err_msg=driver.findElement(ERRO_PSWRD);
        assertTrue(err_msg.isDisplayed());




    }



}
