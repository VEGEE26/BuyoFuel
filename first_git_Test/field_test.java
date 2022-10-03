package first_git_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class field_test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\eclipse\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://app.buyofuel.com/signup");
	    Thread.sleep(3000);
	    driver.findElement(By.name("mobile")).sendKeys("122344555");

	}

}
