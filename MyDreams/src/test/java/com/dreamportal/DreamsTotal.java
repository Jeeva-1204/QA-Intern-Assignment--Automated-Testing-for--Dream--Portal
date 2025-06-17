package com.dreamportal;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DreamsTotal {
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
	private void verifyGoodDreams() {
		WebElement table = driver.findElement(By.id("dreamsDiary"));
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> allRows = tbody.findElements(By.tagName("tr"));
		int rowSize = allRows.size();
		int goodDreams = 0;
		int badDreams=0;
		int flyingOverMountains=0;
		int lostInMaze=0;
		for (int i = 0; i < rowSize; i++) {
			List<WebElement> allColoumn = allRows.get(i).findElements(By.tagName("td"));
			String dreamType = allColoumn.get(2).getText();
//			System.out.println(dreamType);
			if (dreamType.contains("Good")) {
				goodDreams+=1;
			}
			else {
				badDreams+=1;
			}
			
		}
		for (int i = 0; i < rowSize; i++) {
			List<WebElement> allColoumn = allRows.get(i).findElements(By.tagName("td"));
			String dreamType = allColoumn.get(0).getText();
//			System.out.println(dreamType);
			if (dreamType.contains("Flying over mountains")||dreamType.contains("Lost in maze")) {
				flyingOverMountains = 1;
				lostInMaze = 1;
			}
			
			
		}
		int recurringDreams = (flyingOverMountains+lostInMaze);

		System.out.println("GoodDreams = "+goodDreams);
		System.out.println("BadDreams = "+badDreams);
		System.out.println("TotalDreams = "+(goodDreams+badDreams));
		System.out.println("Recurring Dreams = "+recurringDreams);
		driver.navigate().to("https://arjitnigam.github.io/myDreams/dreams-total.html");
		WebElement summaryTable = driver.findElement(By.id("dreamsTotal"));
		WebElement summaryTableBody = summaryTable.findElement(By.tagName("tbody"));
		List<WebElement> summaryTableAllRows = summaryTableBody.findElements(By.tagName("tr"));
		int stRowSize = summaryTableAllRows.size();
		for (int i = 0; i < stRowSize; i++) {
			List<WebElement> summaryTableDatas = summaryTableAllRows.get(i).findElements(By.tagName("td"));
			String stdreamType = summaryTableDatas.get(0).getText();
			String totalCount = summaryTableDatas.get(1).getText();
			int total = Integer.parseInt(totalCount);
			if (total==goodDreams) {
				System.out.println("Good Dream is 6 ");
				
			}
			else if (total==badDreams) {
				System.out.println("Bad Dream is 4");
			}
			else if (total == recurringDreams) {
				System.out.println("Reccurring Dream is 2");
			}
			
			
		}
		
		
	}
	@AfterClass
	private void quitBrowser() {
		driver.quit();

	}

}
