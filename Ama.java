package Group;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Ama {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.amazon.in/");
		
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		
		WebElement signin = driver.findElement(By.id("nav-link-accountList"));   
		
		act.moveToElement(signin).perform();     
		
		driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']")).click();   //click on signin 
		
		WebElement mobNo = driver.findElement(By.id("ap_email"));    //enter mob no.
		mobNo.sendKeys("8329059596");
		
		WebElement continueBtn = driver.findElement(By.id("continue"));
		continueBtn.click();
		
		WebElement password = driver.findElement(By.name("password"));   //enter password
		password.sendKeys("Abcd@1234");
		
		WebElement signinBtn = driver.findElement(By.id("signInSubmit"));
		signinBtn.click();

		WebElement langdropdown = driver.findElement(By.id("icp-nav-flyout"));    //select language
		
		
		Thread.sleep(4000);
		
		act.moveToElement(langdropdown).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.UP).build().perform();
		
		Thread.sleep(3000);
		
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));   //search category
		dropdown.click();
		
		Select sel = new Select(dropdown);
		
		sel.selectByVisibleText("Musical Instruments");
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));   //search sub-category
		searchBox.sendKeys("Wind Flute");
		
		Thread.sleep(3000);
		
		WebElement searchbtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));   //click on search
		searchbtn.click();
		
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver; //scrolling down
		
		js.executeScript("window.scrollBy(0,600)");
			
		Thread.sleep(3000);
		
		WebElement minValue = driver.findElement(By.id("low-price"));  //put limit to product by entering minimum value
		minValue.sendKeys("500");
		
		Thread.sleep(3000);
		
		WebElement maxValue = driver.findElement(By.id("high-price")); //maximum value of product
		maxValue.sendKeys("2000");
		
		Thread.sleep(3000);
		
		WebElement gobtn = driver.findElement(By.className("a-button-input"));    //search product
		gobtn.click();
		
		WebElement sorting = driver.findElement(By.id("a-autoid-0-announce"));     
		sorting.click();

		
		act.moveToElement(sorting).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();  //show product from lower to higher price
		
		Thread.sleep(5000);
		
		WebElement signOut = driver.findElement(By.id("nav-link-accountList"));  //signout  account
		act.moveToElement(signOut).perform();
		
		Thread.sleep(3000);
		
		WebElement signout = driver.findElement(By.xpath("//span[text()='Sign Out']"));
		signout.click();

		Thread.sleep(5000);
		
		driver.quit();   
		
		
	
		
		
		
		
		
		
		
		
		
		
		
	}

}
