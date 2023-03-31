package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MergeContact {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img)[1]")).click();
		String pwindow = driver.getWindowHandle();
//		System.out.println(pwindow);
		String ptitle = driver.getTitle();
//		System.out.println(ptitle);
		Set<String> listofwindowshandles = driver.getWindowHandles();
		for (String each : listofwindowshandles) {
//			System.out.println(each);
					}
		List<String> listofwindows = new ArrayList<>(listofwindowshandles);
		String cWin1 = listofwindows.get(1);
		driver.switchTo().window(cWin1);
//		String title2 = driver.getTitle();
//		System.out.println(title2);
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(pwindow); 
		driver.findElement(By.xpath("(//input[@id='partyIdTo']/following::img)[1]")).click();
		Set<String> listofwindowshandles2 = driver.getWindowHandles();
		for (String each : listofwindowshandles2) {
 //			System.out.println(each);
					}
		List<String> listofwindows2 = new ArrayList<>(listofwindowshandles2);
		String cWin2 = listofwindows2.get(1);
		driver.switchTo().window(cWin2);
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		driver.switchTo().window(pwindow);
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		String title = driver.getTitle();
		System.out.println(title);
		
		
		
	}

}
