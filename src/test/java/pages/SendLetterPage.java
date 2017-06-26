package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class SendLetterPage
{
    private WebDriver driver;
    private WebElement copy_reseiver;
    public static final By WRITE_LETTER_BTN=By.cssSelector(".compose-message-link");
    public static final By RECEIVER_FIELD=By.xpath("//*[@id='toField']");
    public static final By COPY_RECEIVER=By.xpath(".//a[@class='add-copy']");
    public static final By WRITE_THEME =By.xpath(".//input[@name='subject'][@type='text']");
    public static final By COPY_RECEIVER_FIELD=By.id("ccField");
    public static final By SEND_BTN=By.cssSelector(".send-button.button>input");
    public static final By DLG_WINDOW_BTN = By.xpath(".//input[@value='OK'][@type='button']");

    public SendLetterPage(WebDriver driver)//SendLetterPage constructor
    {
        this.driver=driver;
    }
    public void createLetter(String receiver, String theme, String copy_res)
    {
        WebDriverWait wait=new WebDriverWait(driver,15);

        wait.until(ExpectedConditions.visibilityOfElementLocated(WRITE_LETTER_BTN));
        try{
            driver.findElement(WRITE_LETTER_BTN).click();
            driver.findElement(RECEIVER_FIELD).sendKeys(receiver);
            driver.findElement(WRITE_THEME).sendKeys(theme);
            driver.findElement(COPY_RECEIVER).click();
            copy_reseiver=driver.findElement(COPY_RECEIVER_FIELD);
            assertTrue(copy_reseiver.isDisplayed());
            copy_reseiver.sendKeys(copy_res);
        }catch (Exception e){

        }




    }
    public void sendButtonClick() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,15);

        wait.until(ExpectedConditions.visibilityOfElementLocated(SEND_BTN));
        try {
            driver.findElement(SEND_BTN).click();
            String parentHandle = driver.getWindowHandle();
            for(String childHandle : driver.getWindowHandles()){
                if (!childHandle.equals(parentHandle)){
                    driver.switchTo().window(childHandle);
                }
            }
            driver.findElement(DLG_WINDOW_BTN).click();
            driver.switchTo().window(parentHandle);
        }catch (Exception e){

        }



    }
}
