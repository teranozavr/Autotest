/**
 * Created by Admin on 08.06.2019.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import static helpers.WebDriverFactory.createBrowser;

public class OtusPageTestJunit {
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger(FirstTest.class);

    @BeforeClass
    public static void setupClass(){
        //createBrowser("chrome");
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
    }

    @Before
    public void setupTest(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void checkURLTest() throws Throwable{
        driver.get("https://otus.ru");
        Thread.sleep(10000);
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://otus.ru/");
            logger.info("checkURLTest - Passed");
        }
        catch (AssertionError ae)
        {
            logger.error("checkURLTest - Failed");
            throw new Exception();
        }
    }
}
