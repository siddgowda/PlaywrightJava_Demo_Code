import com.microsoft.playwright.*;


public class Demo2_Locators {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://letcode.in/edit");

        page.getByLabel("Consent", new Page.GetByLabelOptions().setExact(true)).click();
        page.locator("#fullName").type("SidduC");
        page.getByPlaceholder("Enter first & last name").fill("Siddu");

        Locator locator = page.locator("#join");
        locator.press("End");
        locator.type(" man");
        locator.press("Tab");
        page.type("#fullName", "Koushik C");
        String value = page.locator("id=getMe").getAttribute("value");
        System.out.println(value);


        playwright.close();
    }

}