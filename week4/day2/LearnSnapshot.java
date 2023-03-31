package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnSnapshot {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		WebElement mobprice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String text = mobprice.getText();
		System.out.println(text);
		WebElement numsofrating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		String text2 = numsofrating.getText();
		System.out.println(text2);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		String pWindows = driver.getWindowHandle();
		Set<String> listofwindowHandles = driver.getWindowHandles();
		for (String each : listofwindowHandles) {
					}
		List<String> listofhandles = new ArrayList<>(listofwindowHandles);
		String cwindow = listofhandles.get(1);
		driver.switchTo().window(cwindow);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/Amazonmob.png");
		FileUtils.copyFile(source, destination);
		driver.findElement(By.xpath("(//span[@class='a-declarative'])[4]")).click();
		WebElement cart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		String text3 = cart.getText();
		String price = text3.replaceAll("₹","");
		String replaceAll = price.replaceAll(".00","");
		if (replaceAll.equals(text)) {
			System.out.println("Price matched");
		} else {
			System.out.println("Price not matched");
		}
		String subtotal = replaceAll.substring(0);
		System.out.println(subtotal);
	}		

}