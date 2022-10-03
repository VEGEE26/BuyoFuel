package first_git_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class git_Buyo_Signup_dataprovider {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","F:\\eclipse\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://app.buyofuel.com/signup");
	    Thread.sleep(3000);
	    
	    //excel file access
	    FileInputStream file=new FileInputStream("F:\\signup.xlsx");
	    XSSFWorkbook book=new XSSFWorkbook(file);
	    XSSFSheet sheet=book.getSheetAt(0);
	    
	    //Access with row and column
	     int  row=sheet.getLastRowNum();
	     int  col=sheet.getRow(0).getLastCellNum();
	     
	     for(int i=1;i<=row;i++)
	     {
	    	XSSFRow cur_row=sheet.getRow(i);
	    	
	    	XSSFCell name=cur_row.getCell(0);
	    	String xl_name=name.toString();
	    	
	    	XSSFCell email=cur_row.getCell(1);
	    	String xl_mail=email.toString();

	    	XSSFCell pass=cur_row.getCell(2);
	    	String xl_pass=pass.toString();

	    	XSSFCell number=cur_row.getCell(3);
	    	String xl_number=number.toString();
	    	
	    	XSSFCell drop=cur_row.getCell(4);
	    	String xl_drop=drop.toString();
	    	
	    	//invoking values from the excel
	    	
	    	driver.findElement(By.xpath("//*[@id=\"App\"]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/form/input[1]")).sendKeys(xl_name);
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//*[@id=\"App\"]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/form/input[2]")).sendKeys(xl_mail);
	    	Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"App\"]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/form/input[3]")).sendKeys(xl_pass);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"App\"]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/form/input[4]")).sendKeys(String.valueOf(xl_number));
            Thread.sleep(3000);
            Select drop_val1=new Select(driver.findElement(By.xpath("//*[@id=\"App\"]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/form/select")));
            drop_val1.selectByVisibleText(xl_drop);
            Thread.sleep(3000);
            //sorting drop-down values
	    	WebElement drop_val=driver.findElement(By.xpath("//*[@id=\"App\"]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/form/select"));
	    	Select btn=new Select(drop_val);
	    	List<WebElement>values=btn.getOptions();
	    	
	    	List ordered=new ArrayList();
	    	
	    	for(WebElement e:values)
	    	{
	    		ordered.add(e.getText());
	    	}
	    		    	
	    	Collections.sort(ordered);
	    	System.out.println("After-Sorting..."+ordered);
	    	Thread.sleep(3000);
	    	driver.navigate().to("https://app.buyofuel.com/signup");
	    	 }
            Thread.sleep(3000);
	        driver.close();
	     	     
	    
	  }
	}

