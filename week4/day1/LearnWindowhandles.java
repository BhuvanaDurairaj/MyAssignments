package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWindowhandles {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
		String pWindow = driver.getWindowHandle();
//		System.out.println(pWindow);
		String title1 = driver.getTitle();
		System.out.println(title1);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String each : windowHandles) {
//			System.out.println(each);
			
		}
		List<String> listofhandles = new ArrayList<>(windowHandles);
		String childwindow = listofhandles.get(1);
		driver.switchTo().window(childwindow);
		String title2 = driver.getTitle();
		System.out.println(title2);
		if (title1.equals(title2)) {
			System.out.println("Page not moved"); 
		} else {
			System.out.println("Page moved to new window");
		}
		
	}

}
