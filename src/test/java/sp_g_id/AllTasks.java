package sp_g_id;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllTasks {

	private static WebDriver driver;

	@BeforeClass
	public static void beforeClass() throws Exception {

		driver = new FirefoxDriver();
		driver.get("http://timvroom.com/selenium/playground/");
	}

	@Test
	public void task01() {
		
		try {
			TimeUnit.SECONDS.sleep(3L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		driver.findElement(By.id("answer1")).sendKeys(driver.getTitle());


	}

	@Test
	public void task02() {

		driver.findElement(By.id("name")).sendKeys("Kilgore Trout");


	}

	@Test
	public void task03() {

		Select dropdown = new Select(driver.findElement(By.id("occupation")));
		dropdown.selectByValue("scifiauthor");


	}

	@Test
	public void task04() {

		int box = driver.findElements(By.className("bluebox")).size();
		String count = String.valueOf(box);
		driver.findElement(By.id("answer4")).sendKeys(count);

	}

	@Test
	public void task05() {

		driver.findElement(By.linkText("click me")).click();
;
	}

	@Test
	public void task06() {

		driver.findElement(By.id("answer6")).sendKeys(driver.findElement(By.id("redbox")).getAttribute("class"));

	}

	@Test
	public void task07() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("ran_this_js_function();");


	}

	@Test
	public void task08() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Long returnValue = (Long) executor.executeScript("return got_return_from_js_function();");
		driver.findElement(By.id("answer8")).sendKeys(String.valueOf(returnValue));

	}

	@Test
	public void task09() {

		driver.findElement(By.xpath("//*[@value='wrotebook']")).click();

	}

	@Test
	public void task10() {

		WebElement element = driver.findElement(By.id("redbox"));
		driver.findElement(By.id("answer10")).sendKeys(element.getText());

	}

	@Test
	public void task11() {
		Point orange = driver.findElement(By.id("orangebox")).getLocation();
		Point green = driver.findElement(By.id("greenbox")).getLocation();

		if (orange.y < green.y) {

			driver.findElement(By.id("answer11")).sendKeys("orange");
		} else {
			driver.findElement(By.id("answer11")).sendKeys("green");
		}


	}

	@Test
	public void task12() {

		Dimension d = new Dimension(850, 650);
		driver.manage().window().setSize(d);
	}

	@Test
	public void task13() {

		List<WebElement> element_ishere = driver.findElements(By.id("ishere"));
		if (element_ishere.size() > 0) {
			driver.findElement(By.id("answer13")).sendKeys("yes");
		} else {
			driver.findElement(By.id("answer13")).sendKeys("no");
		}


	}

	@Test
	public void task14() {
		Boolean purplebox_visible = driver.findElement(By.id("purplebox")).isDisplayed();
		if (purplebox_visible) {
			driver.findElement(By.id("answer14")).sendKeys("yes");

		} else {
			driver.findElement(By.id("answer14")).sendKeys("no");
		}

	}

	@Test
	public void task15() {
		driver.findElement(By.xpath("//a[.='click then wait']")).click();

	}

	@Test
	public void task16() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='click after wait']")));
		wait.pollingEvery(10, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[.='click after wait']")).click();		
		driver.switchTo().alert().accept();


	}
	
	@Test
	public void task17() {
		driver.findElement(By.id("submitbutton")).click();

		}

	@Test
	public void task18() {
		driver.findElement(By.id("checkresults")).click();

		}

	@AfterClass
	public static void afterClass() {

		try {
			TimeUnit.SECONDS.sleep(15L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		driver.close();
	}

}
