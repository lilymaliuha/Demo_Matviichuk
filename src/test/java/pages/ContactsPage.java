package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import static org.testng.Assert.assertEquals;

public class ContactsPage
{
    private WebDriver driver;
    private String compare;
    public static final By CONTACT_TAB= By.xpath(".//a[@class='sidebar-contacts-tab']");
    public static final By ADD_CONTACT_BTN=By.xpath(".//a[@class='sidebar-button sidebar-new-contact']");
    public static final By NAME_CONTACT_FIELD=By.name("fname");
    public static final By SURNAME_CONTACT_FIELD=By.name("lname");
    public static final By EMAIL_CONTACT_FIELD=By.name("email");
    public static final By PHONE_CONTACT_FIELD=By.name("phone");
    public static final By COMPANY_CONTACT_FIELD=By.name("company");
    public static final By BIRTHDAY_CONTACT_FIELD=By.name("birthday");
    public static final By NOTE_CONTACT_FIELD=By.name("note");
    public static final By SAVE_CONTACT_BTN=By.xpath(".//input[@name='save']");


    public static final By Check=By.xpath(".//a[@class='sidebar-mail-tab']");

    public ContactsPage(WebDriver driver)//ContactsPage constructor
    {
        this.driver=driver;
    }

    public void createContact(String name, String surname, String email, String phonenumber, String companyname, String birthdate, String note) throws InterruptedException
    {
        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACT_TAB));
        try{
            driver.findElement(CONTACT_TAB).click();
            Thread.sleep(3000);
            driver.findElement(ADD_CONTACT_BTN).click();
            String parentHandle = driver.getWindowHandle();
            for(String childHandle : driver.getWindowHandles()){
                if (!childHandle.equals(parentHandle)){
                    driver.switchTo().window(childHandle);
                }
            }
            driver.findElement(NAME_CONTACT_FIELD).sendKeys(name);
            driver.findElement(SURNAME_CONTACT_FIELD).sendKeys(surname);
            driver.findElement(EMAIL_CONTACT_FIELD).sendKeys(email);
            driver.findElement(PHONE_CONTACT_FIELD).sendKeys(phonenumber);
            driver.findElement(COMPANY_CONTACT_FIELD).sendKeys(companyname);
          //  driver.findElement(BIRTHDAY_CONTACT_FIELD).sendKeys(birthdate);
            driver.findElement(NOTE_CONTACT_FIELD).sendKeys(note);
            driver.findElement(SAVE_CONTACT_BTN).click();

            driver.switchTo().window(parentHandle);
        }catch (Exception e){
            System.out.println(e);
        }






    }







}
