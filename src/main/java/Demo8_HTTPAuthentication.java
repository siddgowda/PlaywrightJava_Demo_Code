
import com.microsoft.playwright.*;

public class Demo8_HTTPAuthentication {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setHttpCredentials("admin", "admin")
        );
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/basic_auth");
        System.out.println(page.locator("h3").textContent());
        playwright.close();


    }

}