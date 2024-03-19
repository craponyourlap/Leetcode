package helper;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Tag_Extractor {
	static List<String> results = new ArrayList<String>();
	static void extract(String url) {
		// TODO Auto-generated method stub
		//sets up path to the chromedriver
		String system_path = System.getProperty("user.dir");
		String application_path = system_path+"/src/main/resources/resources/chromedriver-win64/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", application_path);
		
		//sets up the chromedriver itself
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);//this is supposed to make the page fully load
		options.addArguments("clear-browsing-data");
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//lets make the driver go to the url -> nice it works
		driver.get(url);
		
		//lets set up the xpaths
		String xpath_to_tags = "//div[@class='mt-2 flex flex-wrap gap-1 pl-7']";
		String xpath_to_topic = "//div[@class='group flex cursor-pointer items-center transition-colors text-label-2 dark:text-dark-label-2 hover:text-label-1 dark:hover:text-dark-label-1']/div[@class='text-[24px] transition-colors text-gray-4 dark:text-dark-gray-4 group-hover:text-gray-5 dark:group-hover:text-dark-gray-5']/svg[@class='[object SVGAnimatedString]']/path[@class='[object SVGAnimatedString]']";
		String xpath_to_window = "//div[@class='flex w-full flex-1 flex-col gap-4 overflow-y-auto px-4 py-5']";
		
		//lets set up the By's
		By tags_by = By.xpath(xpath_to_tags);
		By topic_by = By.xpath(xpath_to_topic);
		By window_by = By.xpath(xpath_to_window);
		
		//lets make the program wait for the website to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		
		try {
			//wait until the window in which we need to scroll down loads
            wait.until(ExpectedConditions.visibilityOfElementLocated(window_by));
            
    		//locate the element in which we need to scroll down
    		WebElement scrollable_element = driver.findElement(window_by);
    		
    		//scroll down the element
    		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollable_element);;
    		
    		//this shit sucks balls, let's just use robot class to click the goddamn tags button
    		//cuz the fucker wont see the shit
    		//using robot class to click tags button
    		Robot robot = new Robot();
    		robot.mouseMove(467, 708);
    		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            
            //wait until tags has loaded
            wait.until(ExpectedConditions.visibilityOfElementLocated(tags_by));
            
            //locate the tags
            WebElement tags_element = driver.findElement(tags_by);
            
            //extract tags
            String tags = tags_element.getText();
            tags = tags.replace("\n", "");
            
            System.out.println(tags);
            
        } catch (Exception e) {
            System.out.println("shit hit the fan, fix it retard: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit(); //i turned it off to see if it works, and it does
        }
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter how many urls: ");
		int elements = in.nextInt();
		System.out.println("Paste urls below in TSV format");
		in.nextLine();
		List<String> urls = new ArrayList<String>();
		for (int i = 0; i < elements; i++) {
			extract(in.nextLine());
		}
	}

}
