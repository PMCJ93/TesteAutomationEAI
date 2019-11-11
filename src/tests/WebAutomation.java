package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home;
import pages.Register;


import java.util.concurrent.TimeUnit;

public class WebAutomation {
    //private static WebDriver driver;
    public static WebDriver driver;

    public static void main(String[] args) {
        driver = browser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Home home = new Home(driver);
        home.NavigateHomePage();
        home.TakeAndSkipTour();
        home.SelectCurrency("US Dollars");
        home.GoToRegister();

        Register register = new Register(driver);
        //Generating random user credentials:
        String email =  "teste_user@test.com";
        String username =  "UserTest";//RandomString(6);
        String password = "password1";//RandomString(9);
        //Proceed to register
        register.SignUpAndRegister(email, username, "+351912345678", password);
        home.ValidateRegister(username);

        //Closing the browser
        driver.close();
    }

    private static WebDriver browser() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
