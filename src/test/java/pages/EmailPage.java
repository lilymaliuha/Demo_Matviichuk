package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailPage
{
    private WebDriver driver;
    public static final By SETTINGS_LINK=By.xpath(".//a[@class='panel-link'][@href='#settings']");


    public EmailPage(WebDriver driver)//EmailPage constructor
    {
        this.driver=driver;
    }
    public void openSettings() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,15);

        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_LINK));
        try {
            driver.findElement(SETTINGS_LINK).click();
            Thread.sleep(3000);
            scrollToElement(SETTINGS_LINK,0,250);
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
    public void scrollToElement(By selector,int x,int y) throws InterruptedException {



        WebElement element=driver.findElement(selector);
        String code = "window.scroll(" + (element.getLocation().x + x) + ","
                + (element.getLocation().y + y) + ");";

        ((JavascriptExecutor) driver).executeScript(code,element,x,y);
        Thread.sleep(5000);

    }


}
