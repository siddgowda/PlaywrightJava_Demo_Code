
/*

-  Debugging feature during runtime (page.pause() )
-  Recording

    Below command to record a test, this command should be executed with the help of Maven
-   mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen facebook.com"

- mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args='codegen --device="iPhone 13" facebook.com'
 */


import com.microsoft.playwright.*;

import com.microsoft.playwright.options.AriaRole;


public class Demo4_RecordTest {
    public static void main(String[] args)
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.facebook.com/");
            page.getByTestId("cookie-policy-manage-dialog-accept-button").click();
            page.getByTestId("open-registration-form-button").click();

            page.pause(); // Playwright runtime debugger

            page.getByPlaceholder("First name").press("CapsLock");
            page.getByPlaceholder("First name").fill("S");
            page.getByPlaceholder("First name").press("CapsLock");
            page.getByPlaceholder("First name").fill("Siddu");
            page.getByLabel("Last name").click();
            page.getByLabel("Last name").press("CapsLock");
            page.getByLabel("Last name").fill("G");
            page.getByLabel("Last name").press("CapsLock");
            page.getByLabel("Last name").fill("Gowda");
            page.getByLabel("Mobile number or email").click();
            page.getByLabel("Mobile number or email").click();
            page.getByLabel("Mobile number or email").fill("171366373636");
            page.getByLabel("New password").click();
            page.getByLabel("New password").fill("siduhf7gf");
            page.getByLabel("Month").selectOption("5");
            page.getByLabel("Day").selectOption("12");
            page.getByLabel("Year").selectOption("2016");
            page.getByLabel("Male", new Page.GetByLabelOptions().setExact(true)).check();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign Up")).click();
            page.getByText("Please enter a valid mobile").click();
        }
    }
}

