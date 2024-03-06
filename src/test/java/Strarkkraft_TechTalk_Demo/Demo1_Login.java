package Strarkkraft_TechTalk_Demo;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/*
How does playwright start:
1. Playwright server
2. Browser ( Chromium [chrome. edge], firefox , safari)
3.Browser context (Browser session )
4. Pages ( like new tab)

 */

public class Demo1_Login {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeTest
    public void setupPlaywrightBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
        context = browser.newContext();
        page = context.newPage();
    }

    @Test(priority = 1)
    public void openBrowser() throws InterruptedException {
        page.navigate("https://opensource-demo.orangehrmlive.com/");
        String HomePage_title = page.title();
        System.out.println("Home page title is: " + HomePage_title);

        //verify title
        Assert.assertEquals("OrangeHRM", HomePage_title); // TestNG Assertion
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException
    {

        page.getByPlaceholder("Username").fill("Admin"); //Playwright locator getByPlaceholder
        page.getByPlaceholder("Password").fill("admin123"); //Playwright locator
        page.locator("button:has-text('Login')").click(); //Playwright locator has-text()

        assertThat(page.locator("//span[text()='Admin']")).isVisible(); //Playwright assertion


    }

    @Test(priority = 3)
    public void logoutTest() throws InterruptedException {

        page.locator("//p[@class=\"oxd-userdropdown-name\"]").click();
        page.getByText("Logout").click(); // Playwright locator getByText

        //Playwright assertion
        assertThat(page.locator("//p[text()='Forgot your password? ']")).hasText("Forgot your password? ");
    }
    //

    @AfterTest
    public void closeBrowser() {
        page.close(); // This will close the page
        context.close(); // This will close the Individual context within browser
        browser.close(); // This will close the browser
        playwright.close(); // This will close the playwright server

    }

}


