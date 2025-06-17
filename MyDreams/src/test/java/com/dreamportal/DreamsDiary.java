package com.dreamportal;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DreamsDiary {
	WebDriver driver;

	@BeforeClass
	private void launchingTheBrowser() {
		driver = new ChromeDriver();
		driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.out.println("Current Page Title is " + driver.getTitle());
	}

	@Test(priority = 1)
	private void validatingDreams() {
		WebElement tableName = driver.findElement(By.xpath("//h1[text()=\"Dreams Diary\"]"));
		String text = tableName.getText();
		System.out.println(text);
		WebElement table = driver.findElement(By.id("dreamsDiary"));
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> allRows = tbody.findElements(By.tagName("tr"));
		int rowSize = allRows.size();
		if (rowSize == 10) {
			System.out.println("10 Dreams Available");

		} else {
			System.out.println("Error");
		}

	}

	@Test(priority = 2)
	private void validateOnlyGoodOrBad() {
		WebElement table = driver.findElement(By.id("dreamsDiary"));
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> allRows = tbody.findElements(By.tagName("tr"));
		int rowSize = allRows.size();
		String dreamType="";
		for (int i = 0; i < rowSize; i++) {
			List<WebElement> allColoumn = allRows.get(i).findElements(By.tagName("td"));
			 dreamType = allColoumn.get(2).getText();
//			System.out.println(DreamType);
		}
		if (dreamType.contains("Good")||dreamType.contains("Bad")) {
			System.out.println("Dreams Type Only Good or Bad");
			
		} else {
			System.out.println("Error");
			
		}

	}
	@Test(priority = 3)
	private void validatingTableContent() {
		WebElement table = driver.findElement(By.id("dreamsDiary"));
		WebElement thead = table.findElement(By.tagName("thead"));
		List<WebElement> tableHeading = thead.findElements(By.tagName("th"));
		for (WebElement allHead : tableHeading) {
			String headings = allHead.getText();
			System.out.print(headings+"\t");
		}
		System.out.println();
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> allRows = tbody.findElements(By.tagName("tr"));
		for (WebElement rows : allRows) {
			List<WebElement> tableData = rows.findElements(By.tagName("td"));
			for (int i = 0; i < tableData.size(); i++) {
				String datas = tableData.get(i).getText();
				System.out.print(datas+"\t");
			}
			System.out.println();
		}
	}
	@AfterClass
	private void quitBrowser() {
		driver.quit();

	}
	

}
