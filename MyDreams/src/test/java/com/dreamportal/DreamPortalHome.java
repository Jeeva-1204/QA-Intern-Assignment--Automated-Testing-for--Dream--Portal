package com.dreamportal;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DreamPortalHome {
	WebDriver driver;

	@BeforeClass
	private void launchingTheBrowser() {
		driver = new ChromeDriver();
		driver.get("https://arjitnigam.github.io/myDreams/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Current Page Title is " + driver.getTitle());
	}

	@Test(priority = 1)
	private void verifyingTheDreamPortalHomePage() throws InterruptedException {
		WebElement loadingPortal = driver.findElement(By.xpath("//h1[contains(text(),\"W\")]"));
		String textContent = loadingPortal.getText();
		System.out.println(textContent);
		Thread.sleep(3000);
		WebElement mainContent = driver.findElement(By.xpath("//h1[contains(text(),\"P\")]"));
		String textMainContent = mainContent.getText();
		System.out.println(textMainContent);
		
	}
	@Test(priority = 2)
	private void verifyingTheButtonMyDreams() {
		WebElement btnMyDreams = driver.findElement(By.id("dreamButton"));
		if (btnMyDreams.isDisplayed() == true) {
			btnMyDreams.click();
		}
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		int count = 0;
		for (String string : allWindows) {

			if (!parentWindow.equals(string)) {
				driver.switchTo().window(string);
				String currentUrl = driver.getCurrentUrl();
				System.out.println(currentUrl);
				count = count + 1;

			}

		}
		System.out.println(count);
		if (allWindows.size() - 1 == count) {
			System.out.println("Clicking \"My Dreams\" opens dreams-diary.html and dreams-total.html \r\n"
					+ "in new tabs/windows.");
		}


	}

	@AfterClass
	private void closeTheBrowser() {
		driver.quit();

	}

}
