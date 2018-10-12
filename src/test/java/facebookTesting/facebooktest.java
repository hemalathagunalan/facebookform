package facebookTesting;


	import java.io.File;
	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;



	public class facebooktest {
	public WebDriver driver;
		@BeforeClass
		public void testSetup()
		{
		
			System.setProperty("webdriver.chrome.driver","D:\\\\appium software\\\\chromedriver_win32\\\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://en-gb.facebook.com/");	
			System.out.println("Driver setup");
		}
		@Test 
		public void namefieldtest()
		{
			try {
			driver.findElement(By.id("u_0_j")).sendKeys("Hema");
			driver.findElement(By.name("lastname")).sendKeys("gunalan");
			driver.findElement(By.id("u_0_o")).sendKeys("9095670275");
			driver.findElement(By.name("reg_passwd__")).sendKeys("1234");
			}
			catch(Exception Error)
			{
					System.out.println("Error");
			}
			}
		@Test
		public void testone()
		{
			try
			{
				String mytitle=driver.getTitle();
				System.out.print(mytitle);
				List<WebElement> radiobuttons=driver.findElements(By.name("sex"));
				//boolean value=false;
				boolean button_value1=radiobuttons.get(0).isSelected();
				if(button_value1)
				{
					System.out.println("User is female");
				}
				else
				{
					boolean button_value2=radiobuttons.get(1).isSelected();
					if(button_value2)
					{
						System.out.println("User is male");
						//System.out.println("At least click any option");
					}
					else
					{
						for(int i=0;i<2;i++)
						{
						String user_sex=radiobuttons.get(i).getAttribute("value");
						if(user_sex.equalsIgnoreCase("1"))
						{
							radiobuttons.get(i).click();
							System.out.println("\n clicked\n");
						}
				
						}
				
					}
				}
			Thread.sleep(1000);
		}catch(Exception e)
			{
			System.out.println(e);
			}
			try {
			File screeshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screeshot,new File("D:\\\\screenshot.png"));
			System.out.println("radio button selection success");
			}catch(Exception Error)
			{
			System.out.println("Error catching " + Error);
			}
		}
	@Test
	public void selectcase()throws Exception
	{
		try {
			Select dropdown=new Select(driver.findElement(By.name("birthday_day")));
			dropdown.selectByValue("11");
			
			Select dropdown_month=new Select(driver.findElement(By.name("birthday_month")));
			dropdown_month.selectByValue("8");
			
			Select dropdownyear=new Select(driver.findElement(By.id("year")));
			dropdownyear.selectByVisibleText("1988");
			
			System.out.print("screenshot");
		
		Thread.sleep(5000);	
		}
		catch(Exception E)
		{
			System.out.print(E);
		}
		System.out.println("Dropdown selection sucess");
		
	}
	@AfterClass
	public void session()
	{
		System.out.println("Driver exit");
		driver.quit();
	}
	}

	  