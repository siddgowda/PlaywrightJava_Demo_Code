
import com.microsoft.playwright.*;

import java.nio.file.Paths;

/*
How does playwright start:
1. Playwright server
2. Browser ( Chromium [chrome. edge], firefox , safari)
3.Browser context (Browser session )
4. Pages ( like new tab)

 */

public class Demo1_LauchBrowser {


    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();


        page.navigate("https://web.magentatv.de/");


        Thread.sleep(5000);

        page.locator("//button[contains(text(),'Alle akzeptieren')]").click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./snaps/magenta.png"))
                .setFullPage(true));
        System.out.println("Page title is " + page.title());

        page.close();
        browser.close();
        playwright.close();
    }

}