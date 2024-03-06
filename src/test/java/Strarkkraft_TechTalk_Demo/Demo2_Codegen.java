package Strarkkraft_TechTalk_Demo;

/*

-  Debugging feature during runtime (page.pause() )
-  Recording

    Below command to record a test, this command should be executed with the help of Maven
-   mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen facebook.com"
- mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen /opensource-demo.orangehrmlive.com"
 */

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Demo2_Codegen {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            page.getByPlaceholder("Username").click();
            page.getByPlaceholder("Username").press("CapsLock");
            page.getByPlaceholder("Username").fill("A");
            page.getByPlaceholder("Username").press("CapsLock");
            page.getByPlaceholder("Username").fill("Admin");
            page.getByPlaceholder("Password").click();
            page.getByPlaceholder("Password").fill("admin123");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
            page.locator("span").filter(new Locator.FilterOptions().setHasText("Kevin Tester")).click();
            page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Logout")).click();
            page.getByText("Forgot your password?").click();
        }
    }
}
