package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossDriver {
    private CrossDriver(){
        // Singleton pattern konsepti ile
        // Driver class'indan obje olusturmayi engellemek icin bu cons.'i olusturduk
    }
    static WebDriver driver;
    public static WebDriver getDriver(String browser){

        browser= browser==null ? ConfigReader.getProperty("browser"):browser;

        if(driver==null) {// method ilk cagrildiginda driver degeri atanmamis oldugundan deger ata
            // sonraki calistirmalarda degeri atanmis oldugundan 18.satir calismayacak

            switch (browser){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }

       //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }
    }
}
