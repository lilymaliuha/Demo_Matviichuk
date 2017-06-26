package tests.SeleniumGridTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Selenium_Grid_Tests {
    private WebDriver driver;
    public String URL, Node;
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;

    private LoginPage loginPage;//create object of a LoginPage
    private EmailPage emailPage = new EmailPage(driver);
    private SettingsPage settingsPage;
    private SendLetterPage sendLetterPage;
    private ContactsPage contactsPage;

    @Parameters("browser")
    @BeforeTest
    public void launchbrowser(String browser) throws MalformedURLException {


        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println(" Executing on FireFox");
            String Node = "http://192.168.2.104:5557/wd/hub";
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");

            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        } else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println(" Executing on CHROME");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            String Node = "http://192.168.2.104:5556/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        } else if (browser.equalsIgnoreCase("internet explorer")) {
            System.out.println(" Executing on IE");
            DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
            cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            cap.setCapability("requireWindowFocus", true);
            cap.setBrowserName("internet explorer");
            String Node = "http://192.168.2.104:5558/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage()
    {
        loginPage = new LoginPage(driver).open();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }

    @Test(retryAnalyzer = Retry.class,priority = 0, groups = { "settings" }, description = "Create a new filter and delete it after creation")
    public void changeFilter() throws InterruptedException {

        loginPage.loginAs("larysamat@ukr.net", "larysa2526565");
        emailPage = new EmailPage(driver);
        emailPage.openSettings();
        settingsPage = new SettingsPage(driver);

        settingsPage.createFilter("latysdas@das.das");
        settingsPage.deleteFilter();
        loginPage.logOut();

    }
    @Test(retryAnalyzer = Retry.class,priority = 1, groups = { "settings" }, description = "Input not right data into repeat password field ")
    public void changePswrd() throws InterruptedException
    {
        loginPage.loginAs("larysamat@ukr.net", "larysa2526565");
        emailPage=new EmailPage(driver);
        emailPage.openSettings();
        settingsPage=new SettingsPage(driver);
        settingsPage.changePassword("larysa2526565", "1111", "1122");
        loginPage.logOut();


    }

    @Test(retryAnalyzer = Retry.class,priority = 2, groups = { "letters" }, description = "Create a new letter with illegal data for receiver")
    public void sendLetter() throws InterruptedException {
        loginPage.loginAs("larysamat@ukr.net", "larysa2526565");
        sendLetterPage=new SendLetterPage(driver);
        sendLetterPage.createLetter("12345", "Demo_Matviichuk", "L00009@rambler.ru");
        sendLetterPage.sendButtonClick();
        loginPage.logOut();

    }

    @Test(retryAnalyzer = Retry.class,priority = 3, groups = { "contacts" }, description = "Create a new contact in address book")
    public void makeContact() throws InterruptedException {
        loginPage.loginAs("larysamat@ukr.net", "larysa2526565");
        contactsPage=new ContactsPage(driver);
        Random ran =new Random();
        int n =100000+ran.nextInt(900000);
        contactsPage.createContact("Liliia", "Matviichuk", n+"@rambler.ru", "8063443434", "Dunkin", "25/06/2017", "New contact");
        loginPage.logOut();

    }


}
