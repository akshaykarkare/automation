package stepdefinition;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import okhttp3.Request;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Clock;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class commonSD extends context.commonMethods{
    public commonSD(TestContext context){
    super(context);
    }

    //Open Website
    @Given("^Open \"([^\"]*)\" Website$")
    public void openURL(String URL) throws IOException {
        System.out.println("Opening: "+URL);
        navigate(URL);
    }

    //ClickOnElement
    @Then("^click on \"([^\"]*)\"$")
    public void clickOn(String element) throws IOException {
        System.out.println("clicking: "+ element);
        click(element);
    }
    //print to report
    @Given("^Print \"([^\"]*)\" statement$")
    public void print(String printText) {
        hooks.getScenario().log(printText);
    }

    //take screenshot
    @Given("^capture screenshot$")
    public void takeScreenshot() throws IOException {
        hooks.takeScreenshot(driver);
    }

    //testing purpose
    @Given("^scroll")
    public void scroll() throws InterruptedException {
        System.out.println(System.getProperty("user.dir"));
       JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("document.body.style.zoom = '1.5'");
//        Thread.sleep(5000);
//        executor.executeScript("document.body.style.zoom = '1'");
//        Thread.sleep(5000);
        //Thread.sleep(5000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement element = driver.findElement(By.xpath("//span[text()=\"Why book with Yatra.com?\"]"));
//        js.executeScript("arguments[0].scrollIntoView();",element);
//        if(element.isDisplayed()) {
//            System.out.println(element.getText()+"      "+element.isDisplayed());
//        }
//        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");

        //Thread.sleep(5000);
    }

    @Given("^actions")
    public void actions() throws InterruptedException, AWTException {
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       WebDriverWait wait = new WebDriverWait(driver, 100);
       List<WebElement> el = driver.findElements(By.tagName("div"));
       //wait.until(ExpectedConditions.visibilityOfAllElements(el));

        WebElement element = driver.findElement(By.xpath("//a[@title=\"Round Trip\"]"));
        Actions act = new Actions(driver); //class
        act.click(element).build().perform();
        try{}catch(WebDriverException e){}
        WebElement myAcc = driver.findElement(By.xpath("//li[@id='userLoginBlock']"));
        act.moveToElement(myAcc).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@id='signInBtn']")).click();
        //Alert al = driver.switchTo().alert(); // Interface
        //act.contextClick(element).build().perform();
        //act.contextClick(element);
        //act.clickAndHold(element);
        Thread.sleep(10000);
    }

    @Given("do things")
    public void do_thing(DataTable creds) {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> data = creds.asLists();
        System.out.println("do things   "+ data.get(0).get(1) );
    }

    @Given("^google \"([^\"]*)\" search")
    public void goggleTesting(String searchtext) {
        String se = "exceptions";
        System.out.println(searchtext);

       int i= driver.findElements(By.xpath("//div[@jscontroller='Dvn7fe']")).size();
       System.out.println(i+" size");
       boolean flag = driver.findElement(By.xpath("//div[@jscontroller='Dvn7fe']")).isDisplayed();
       System.out.println("before : "+flag);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchtext);
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@jscontroller='Dvn7fe']")));
        flag = driver.findElement(By.xpath("//div[@jscontroller='Dvn7fe']")).isDisplayed();
        System.out.println("after "+flag);
        List<WebElement> ele = driver.findElements(By.xpath("//div[@jscontroller='Dvn7fe']//span//b"));
        for(WebElement e: ele){
            //System.out.println(e.getText());
            if(e.getText().equals(se)){
                e.click();
            }
        }
    }

    @Given("^find out broken links on page")
    public void brokenLinks(){
        int brokenLinkCount=0;
        List <WebElement> e = driver.findElements(By.tagName("a"));
        System.out.println(e.size());
        for (WebElement link: e){
            String URL = link.getAttribute("href");

            if(URL==null){
                brokenLinkCount++;
            }

            else if (URL!=null){
                RequestSpecification request = RestAssured.given();
                Response response = request.get(URL);
                if (response.getStatusCode()!=200){
                    brokenLinkCount++;
                    System.out.println(" status code: "+response.getStatusCode()+" and URL is :"+ URL);
                }
            }

        }
        System.out.println("total broken link counts are: "+brokenLinkCount);
    }


}
