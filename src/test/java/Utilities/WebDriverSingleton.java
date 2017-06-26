//package Utilities;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public  class WebDriverSingleton
//{
//
//    public static  WebDriver Instance=null;
//
//    public static void Initialize()
//
//
//{
//    if(Instance==null) //If instance is null we initialize the driver
//    {System.out.print("Initializing driver");
//       if(myConfig.myBrowser.browser.equalsIgnoreCase("ff"))//take browser from the Configuration package from the config class
//       {
//           System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
//           Instance = new FirefoxDriver();
//       }
//       else if (myConfig.myBrowser.browser.equalsIgnoreCase("ie"))
//       {
//           System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");
//           Instance = new InternetExplorerDriver();
//       }
//       else if (myConfig.myBrowser.browser.equalsIgnoreCase("chrome"))
//       {
//           System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
//           Instance = new ChromeDriver();
//       }
//    }
//    Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    Instance.manage().window().maximize();
//}
//public static void close()
//{
//    System.out.println("Close the browser");
//    Instance.close();
//    Instance=null;larysamat@ukr.net
//}
//    public static void quit()
//    {
//        System.out.println("Quite from the browser");
//        Instance.quit();
//        Instance=null;
//    }
//}
