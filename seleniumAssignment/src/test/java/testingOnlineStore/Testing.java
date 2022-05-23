package testingOnlineStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {
	public static void main(String[] args) {
		
		
		//brower setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//getting into store and login
		
		driver.get("http://automationpractice.com/index.php");
		WebElement button= driver.findElement(By.className("login"));
		button.click();
		WebElement name=driver.findElement(By.id("email"));
		name.sendKeys("rima321@gmail.com",Keys.ENTER);

		driver.findElement(By.name("passwd")).sendKeys("music1");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		
		
		//moving into women dressing(mouse actions)
		
		Actions action = new Actions(driver);

		WebElement women = driver.findElement(By.xpath("//li//a[@class='sf-with-ul']"));
		action.moveToElement(women).build().perform();
		WebElement tshirt = driver.findElement(By.xpath("//li//a[contains(text(),'T-shirts')]"));
		action.moveToElement(tshirt).click().perform();
		

		JavascriptExecutor jsExecute = (JavascriptExecutor) driver;
		jsExecute.executeScript("window.scrollTo(0,800)");
		
		//selecting T shirt size and increasing quantity

		WebElement dress = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		action.moveToElement(dress).build().perform();

		driver.findElement(By.linkText("More")).click();

		driver.findElement(By.xpath("//a//span//i[@class='icon-plus']")).click();
		
		
		//drop-down is handled with help of select class
		
		
		Select scl = new Select(driver.findElement(By.id("group_1")));
		scl.selectByVisibleText("L");

		driver.findElement(By.id("color_14")).click();
		jsExecute.executeScript("window.scrollTo(0,400)");
		driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();  //checkout
		driver.close();
		driver.quit();
		System.out.println("---------------completed----------------");//end of program
	}

}
