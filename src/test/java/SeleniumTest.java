//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class SeleniumTest {

//    static WebDriver browser;


//    options = webdriver.ChromeOptions()
//    driver = webdriver.Chrome(service=service, options=options)

    @Test
    void setup() {


//                System.setProperty(
//                "webdriver.chrome.driver", System.getProperty("user.dir")
//                + "/src/test/resources/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments("start-maximized"); // open Browser in maximized mode
//        options.addArguments("disable-infobars"); // disabling infobars
//        options.addArguments("--disable-extensions"); // disabling extensions
//        options.addArguments("--disable-gpu"); // applicable to Windows os only
//        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
//        options.addArguments("--no-sandbox"); // Bypass OS security model
//        options.addArguments("--disable-in-process-stack-traces");
//        options.addArguments("--disable-logging");
//        options.addArguments("--log-level=3");
//        options.addArguments("--remote-allow-origins=*");

        driver.get("https://www.hdfcbank.com/");

//        Finding all link on the web page

//        String url="";
//        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
//        System.out.println("Total links on the Wb Page: " + allURLs.size());
//
//        //We will iterate through the list and will check the elements in the list.
//
//        Iterator<WebElement> iterator = allURLs.iterator();
//        while (iterator.hasNext()) {
//            url = iterator.next().getText();
//            System.out.println(url);
//
//        }

//

        //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // This line will print the number of links and the count of links.
        System.out.println("No of links are " + links.size());

        //checking the links fetched.
        for (int i = 0; i < links.size(); i++) {
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
            verifyLinks(url);
        }

//        driver.quit();
    }


    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }


//        driver.quit();


    }
}
