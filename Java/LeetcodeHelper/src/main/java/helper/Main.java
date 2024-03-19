package helper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String system_path = System.getProperty("user.dir");
		String application_path = system_path+"/src/main/resources/resources/chromedriver-win64/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", application_path);
		
		// Instantiate ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://leetcode.com/problems/binary-tree-inorder-traversal/description/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions");

        // Scroll to the button
        WebElement button = driver.findElement(By.xpath("//div[@class='mt-6 flex flex-col gap-3']/div[4]//div[@class='text-sd-foreground flex items-center gap-2']"));
        scrollToElement(driver, button);

        // Click on the button
        button.click();

        // Wait for the text element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mt-2 flex flex-wrap gap-1 pl-7']")));

        // Extract text from the element
        String text = element.getText();

        // Print the extracted text
        System.out.println("Extracted text: " + text);

        // Close the browser
        driver.quit();
    }

    // Scroll to an element using JavaScript
    private static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
