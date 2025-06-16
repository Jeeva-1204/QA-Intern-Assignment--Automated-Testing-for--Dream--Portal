package com.dreamportal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DreamsDiary {
	WebDriver driver;

	@BeforeTest
	private void launchingTheBrowser() {
		driver = new ChromeDriver();
		driver.get("https://arjitnigam.github.io/myDreams/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Current Page Title is " + driver.getTitle());
	}
	@Test
	private void validatingTableContent() {
		WebElement tableName = driver.findElement(By.xpath("//h1[text()=\"Dreams Diary\"]"));
		String text = tableName.getText();
		System.out.println(text);
		

	}

}
