
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


/*

Browser Context :

 - Normally Selenium or any web test tool will bot store any data and everytime they open fresh browser
 - In selenium, we don't have option to laucnh a new browser but selenium 4 we have new tab

 Context - browser
 context1 - browser 1
 context2 - browser 2
 add new Page - will create a new tab

 */

public class Demo9_BrowserContext {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.firefox();
        LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = browserType.launch(headless);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://bookcart.azurewebsites.net/");
        page.click("//span[text()='Login']/..");
        page.locator("input[formcontrolname='username']").type("ortoni");
        page.locator("input[formcontrolname='password']").type("Pass1234$");
        page.locator("button[color='primary']").click();
        String userName = page.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]").textContent();
        System.out.println(userName.split(" ")[1].split(" ")[0]);

        BrowserContext context2 = browser.newContext();
        Page newPage = context2.newPage();
        newPage.navigate("https://bookcart.azurewebsites.net/");
//		userName = newPage.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]").textContent();
//		System.out.println(userName.split(" ")[1].split(" ")[0]);
//		newPage.close();
//		context2.close();
//
        page.bringToFront();
        page.locator("input[type='search']").type("HP3");

        playwright.close(); //This will close everything ( pages, browser, playwright server)


    }

}