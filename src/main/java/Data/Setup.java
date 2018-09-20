package Data;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Setup {

    public static WebDriver driver;

    String dataFilePath = "E:\\YJPWork\\Code\\FrameWorkPractice\\src\\main\\resources\\Data.properties";

    public WebDriver InitializeDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(dataFilePath);
        properties.load(file);
        String browserName = properties.getProperty("Browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\Firefoxdriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String refFormatNowDate() {
        Date nowTime = new Date(System.currentTimeMillis());//获取当前系统时间
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//设置日期格式
        String retStrFormatNowDate = sdFormatter.format(nowTime);//使当前系统时间用到模板是设置好的模板
        return retStrFormatNowDate;//返回这个设置好的时间模板
    }

    public void screenShot(String name) throws IOException {
        String filePath = "E:\\YJPLPIC";
        String fileName = refFormatNowDate() + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(filePath + "\\" + name + fileName));
    }
}
