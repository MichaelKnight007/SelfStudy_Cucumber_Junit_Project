package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    // #1 Create a private constructor to limit access to the object

    private Driver() {
    }


    // ************************ getDriver Method for Single Driver. ************************
    /*// #2 Create private driver object


   // We create a private WebDriver driver object to limit access from outside the class.
    //We make it static because we'll use it in a static method.

    private static WebDriver driver;

    /// / Default value is null


    public static WebDriver getDriver() {

        if (driver == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome" -> {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
                case "firefox" -> {
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }

                case "edge" -> {
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
            }
        }
        return driver;
    }


    // Close drive method for only single driver

    public static void closeDriver() {
        if (driver != null) {


           // This line will terminate the currently existing driver completely.
            driver.quit();


            //We assign the value back to "null" so that my "singleton" can create a newer one if needed.

            driver = null;


           // Eğer biz bu method yerine driver.quit() kullanırsak, arka arkaya testleri açamaz, NoSuchSessionException hatası verir ve ilk test bitince diğerlerini çalıştırmaz.
            //Ancak bu method sayesinde her bir test bittiğinde yenisi çalışacaktır. Çünkü bu method ile biz driver'a tekrar null değerini atıyoruz.

            }
         }
             */





    // ----------------------------getDriver Method for Multiple Drivers. -----------------


   // #2 Create private InheritableThreadLocal object

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome" -> {
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
                case "firefox" -> {
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }

                case "edge" -> {
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }
                case "headless-chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(options));
                }
            }
        }
        return driverPool.get();
    }


    // Close drive method for only single driver

    public static void closeDriver() {
        if (driverPool.get() != null) {


            // This line will terminate the currently existing driver completely.
            driverPool.get().quit();


            //remove() method will assign null value to each driver. Or we van use driverPool.set() method

         //   driverPool.set(null);
            driverPool.remove();


            // Eğer biz bu method yerine driver.quit() kullanırsak, arka arkaya testleri açamaz, NoSuchSessionException hatası verir ve ilk test bitince diğerlerini çalıştırmaz.
           // Ancak bu method sayesinde her bir test bittiğinde yenisi çalışacaktır. Çünkü bu method ile biz driver'a tekrar null değerini atıyoruz.

        }
    }

}
