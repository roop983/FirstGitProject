package com.org.sampleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {

	static WebDriver driver=null;
	@BeforeClass
	public void initTest()
	{
		driver = new FirefoxDriver();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
	}
	
	@Test
	public void testLogin()
	{
		WebElement deals=driver.findElement(By.xpath("//div[@id='nav-xshop']/a[2]"));
		deals.click();
		Actions action = new Actions(driver);
		WebElement sort=driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div[2]/div/span[3]/span/span/span/span"));
		action.moveToElement(sort).build().perform();
		sort.click();
		Actions action1 = new Actions(driver);
		WebElement sort_by=driver.findElement(By.xpath("/html/body/div[13]/div/div/ul/li[5]/a"));     
		action1.moveToElement(sort_by).build().perform();
		sort_by.click();
		WebElement select=driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/a/div/div/div[2]"));
		select.click();
		WebElement actual_product_title=driver.findElement(By.xpath("//span[@id='productTitle']"));
		String actual_product_title_text=actual_product_title.getText();
		System.out.println(actual_product_title_text);
		WebElement actual_product_price=driver.findElement(By.xpath("//span[@id='priceblock_dealprice']"));
		String actual_product_price_text=actual_product_price.getText();
		System.out.println(actual_product_price_text);
		
		WebElement add_cart=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		add_cart.click();
		WebElement view_cart=driver.findElement(By.xpath("//a[@id='hlb-view-cart-announce']"));
		view_cart.click();
		WebElement exp_product_title=driver.findElement(By.xpath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div[2]/div[1]/div/div/div[2]/ul/li[1]/span/a/span"));
		String exp_product_title_text=exp_product_title.getText();
		WebElement exp_product_price=driver.findElement(By.xpath("//[@id='activeCartViewForm']/div[2]/div/div[4]/div[2]/div[2]/p[1]/span"));
		String exp_product_price_text=actual_product_price.getText();
		
		if (actual_product_price_text.contains(exp_product_title_text) && actual_product_price_text.equalsIgnoreCase(exp_product_price_text) )
		System.out.println("Equal");
		else
			System.out.println("Not Equal");	
	}
}
