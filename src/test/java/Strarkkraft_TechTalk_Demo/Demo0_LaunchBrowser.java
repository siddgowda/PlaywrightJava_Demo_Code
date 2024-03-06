package Strarkkraft_TechTalk_Demo;


import com.microsoft.playwright.*;
import org.testng.Assert;

import java.nio.file.Paths;

/*
How does playwright start:
1. Playwright server
2. Browser ( Chromium [chrome. edge], firefox , safari)
3.Browser context (Browser session )
4. Pages ( like new tab)

 */

public class Demo0_LaunchBrowser {


    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create(); // 1. Playwright server

        //Browser ( Chromium [chrome. edge], firefox , safari)
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
        //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        // browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        // browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext(); //3.Browser context (Browser session )
        Page page = browserContext.newPage(); // 4. Pages ( like new tab)


        //Test
        page.navigate("https://opensource-demo.orangehrmlive.com/");
        String HomePage_title = page.title();
        System.out.println("Home page title is: " + HomePage_title);

        //verify title
        Assert.assertEquals("OrangeHRM", HomePage_title); // TestNG Assertion

        //Close browser
        page.close();
        browser.close();
        playwright.close();
    }

}