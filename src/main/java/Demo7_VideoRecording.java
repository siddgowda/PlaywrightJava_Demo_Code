import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

/*

To record a video in playwright

- We have to add below code in Browser context

BrowserContext context = browser.newContext(new Browser.NewContextOptions().
                setRecordVideoDir(Paths.get("Videos")).setViewportSize(1920, 1080));

You can check your view port here : https://whatismyviewport.com/
 */
public class Demo7_VideoRecording {


    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().
                setRecordVideoDir(Paths.get("Videos")).setViewportSize(1920, 1080));
        Page page = context.newPage();

        page.navigate("https://www.facebook.com/");
        page.getByTestId("cookie-policy-manage-dialog-accept-button").click();
        page.getByTestId("open-registration-form-button").click();
        page.getByPlaceholder("First name").click();
        page.getByPlaceholder("First name").press("CapsLock");
        page.getByPlaceholder("First name").fill("S");
        page.getByPlaceholder("First name").press("CapsLock");
        page.getByPlaceholder("First name").fill("Siddeshwar");
        page.getByLabel("Last name").click();
        page.getByLabel("Last name").press("CapsLock");
        page.getByLabel("Last name").fill("G");
        page.getByLabel("Last name").press("CapsLock");
        page.getByLabel("Last name").fill("Gowda");
        page.getByLabel("Mobile number or email").click();
        page.getByLabel("Mobile number or email").fill("1524363545");
        page.getByLabel("New password").click();
        page.getByLabel("New password").fill("siddugowda");
        page.getByLabel("Month").selectOption("5");
        page.getByLabel("Day").selectOption("10");
        page.getByLabel("Year").selectOption("1993");
        page.getByLabel("Male", new Page.GetByLabelOptions().setExact(true)).check();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign Up")).click();

        playwright.close();
    }
}
