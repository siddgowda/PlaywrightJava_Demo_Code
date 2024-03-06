import com.microsoft.playwright.*;

/*

You can maximize window depending on the size of the screen

You can check your view port here : https://whatismyviewport.com/
 */
public class Demo6_MaximizeBrowser {


    public static void  main(String[] args){

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
        Page page = context.newPage();

        page.navigate("https://web.magentatv.de/");

        playwright.close();
    }
}
