package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    WebDriver driver;

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public void SignUpAndRegister(String email, String username, String phoneNumber, String password) {
        //email
        driver.findElement(By.xpath("//*[@name='signup_email']")).sendKeys(email);
        //Click on next button
        driver.findElement(By.xpath("//button[contains(@class,'signUpNextButtonClass')]")).click();
        //Signup screen 2
        verifyelement(username, phoneNumber, password);

    }

    //check if the element is correctly filled
    private void verifyelement(String username, String phoneNumber, String password) {
        String user =  driver.findElement(By.xpath("//*[@name='signup_email']")).getText();
        if (user != username) {
            driver.findElement(By.xpath("//*[@name='firstlastname']")).sendKeys(username);
        }
        String phone = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).getText();
        if (phone != phoneNumber) {
            driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys(phoneNumber);
        }
        String pass = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).getText();
        if (pass != password)  {
            driver.findElement(By.xpath("//*[@name='signup_password']")).clear();
            driver.findElement(By.xpath("//*[@name='signup_password']")).sendKeys(password);
        }
        //submit account
        driver.findElement(By.xpath("//button[@class='submitButton']")).click();
    }

}
