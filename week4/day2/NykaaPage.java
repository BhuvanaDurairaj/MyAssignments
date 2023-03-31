package week4.day2; doubt

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaPage {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		WebElement brandele = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brandele).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//a[contains(text(),'Paris')]")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.id("first-filter")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//label[contains(@for,'Shampoo')]")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//label[contains(@for,'Color Protection')]")).click();
		WebElement shampooName = driver.findElement(By.xpath("//div[@class='css-xrzmfa']']"));
		String text = shampooName.getText();
		if (text.contains("Paris Colour Protect Shampoo")) {
			System.out.println("Shampoo Filtered");
		}
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		String pWindows = driver.getWindowHandle();
		Set<String> listofwindowHandles = driver.getWindowHandles();
		for (String each : listofwindowHandles) {
					}
		List<String> listofhandles = new ArrayList<>(listofwindowHandles);
		String cwindow = listofhandles.get(1);
		driver.switchTo().window(cwindow);
		driver.findElement(By.xpath("(//button[@type='button']/span)[1]")).click();
//		String price = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
//		System.out.println(price);
//		driver.findElement(By.xpath("//span[@class='btn-text']")).click();
//		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();


	}

}
