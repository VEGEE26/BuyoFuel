package first_git_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_run {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\eclipse\\driver\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://buyofuel.com/");
		Thread.sleep(3000);
		System.out.println("Succesfully opened and closed");
		driver.close();
		
	}

}
