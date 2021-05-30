import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

 class AutomationPractice{
	
	WebDriver driver;
	public void launchApp(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\Project\\Java_selenium_ATC\\Server\\chromedriver.exe"); 
		driver= new ChromeDriver(); 
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void mainCode() throws IOException{
		driver.findElement(By.xpath("//div[@class='header_user_info']/a[@class='login']")).click();

		//Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("qmerty@gmail.com");

		//Password
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345");

		//Sign In
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

		//My Addresses
		driver.findElement(By.xpath("//a[@title='Addresses']")).click();

		//To add new Address
		driver.findElement(By.xpath("//a[@title='Add an address']")).click();

		//Company
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("ATC");

		//Address1
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Madhavam,123 Street");

		//Address2
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Thirumullavaram");

		//City
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kollam");

		//State
		Select s1 = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		s1.selectByValue("31");

		//ZipPostalCode
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("69101");

		//HomePhone
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("2792293");

		//Mobile
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("9876543234");

		//Additional info
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("text");

		//future ref
		driver.findElement(By.xpath("//input[@id='alias']")).clear();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("North Town, NewYork");

		//Save button
		driver.findElement(By.xpath("//button[@id='submitAddress']")).click();

		//Navigate to women Summer dresses
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[@title='Women']"));

		actions.moveToElement(mainMenu);

		WebElement subMenu = driver.findElement(By.xpath("//a[@title='Summer Dresses']"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();


		//Change to List View
		driver.findElement(By.xpath("//a[@title='List']")).click();

		//Iterating 3 times to select 3 dresses
		for(int k=0;k<3;k++){
			//Select the first item
			List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@id='center_column']/ul[@class='product_list row list']//div[contains(@class,'center')]//h5/a"));

			for(int i=k;i<listOfElements.size();){
				listOfElements.get(i).click();
				break;
			}// i loop close

			
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			WebElement quant = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//a[contains(@class,'plus')]")));
			WebElement plus=driver.findElement(By.xpath("//div//a[contains(@class,'plus')]"));
			
			//Increase the quantity to 5
			for(int j=0;j<4;j++){
				if(quant.getText().equals("5")){
					break;
				}	 
				plus.click();
			}//j loop close

			//Change the size to 'L'
			Select s2 = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
			s2.selectByValue("3");

			//Select any colour.
			driver.findElement(By.xpath("//a[@id='color_16']")).click();

			//Add to cart
			driver.findElement(By.xpath("//button/span[text()='Add to cart']")).click();

			if(k!=2){
				//Continue Shopping
				driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

				//Back to summer dresses
				driver.findElement(By.xpath("//span[@class='navigation-pipe']/following::a[@title='Summer Dresses']")).click();
			}//if closes
		}//K loop close


		//Proceed to checkout and complete the payment
		//Summary
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();

		//Sign in
		driver.findElement(By.xpath("//h1[@id='cart_title']/following::a[@title='Proceed to checkout']")).click();

		//Address
		driver.findElement(By.xpath("//h1[text()='Addresses']/following::button[@type='submit' and @name='processAddress']")).click();

		//Terms and Condition Checkbox
		driver.findElement(By.xpath("//input[@id='cgv']")).click();

		//Shipping
		driver.findElement(By.xpath("//h1[text()='Shipping']/following::button[@type='submit' and @name='processCarrier']")).click();

		//Payment mode
		driver.findElement(By.xpath("//a[@class='cheque']")).click();

		//Confirm order
		driver.findElement(By.xpath("//button[@type='submit' and contains(@class,'medium')]")).click();


		//Move to your profile and check 'order history and details'
		driver.findElement(By.xpath("//a[@title='View my customer account']")).click();
		driver.findElement(By.xpath("//a[@title='Orders']")).click();

		//Capture screenshot of the order history
		TakesScreenshot Scrnshot =((TakesScreenshot)driver);
		File file= Scrnshot.getScreenshotAs(OutputType.FILE);

		File Dest=new File("C:\\Users\\user\\Desktop\\Project\\Java_selenium_ATC\\ScreenShot\\ScreenShot.bmp");
		FileUtils.copyFile(file,Dest);

		//Sign out
		driver.findElement(By.xpath("//a[@class='logout']")).click();

	} //main closes

	
	public void close(){
		driver.close();
	}

}//class

















