
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;

/*
   Trace viewer

   - To start the trace viewer, add below code after BrowserContext.

  1.  // Start tracing before creating / navigating a page.
context.tracing().start(new Tracing.StartOptions()
  .setScreenshots(true)
  .setSnapshots(true)
  .setSources(true));

 2.  // Stop tracing and export it into a zip archive.
context.tracing().stop(new Tracing.StopOptions()
  .setPath(Paths.get("trace.zip")));

  3. To open the trace
   Option 1 -https://trace.playwright.dev/
   Option 2 - mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace C:\Users\delltest03\Playwright_Demo_Code\trace.zip"
    ( With option 2, we have to mention the full path name trace file )

Note: trace.zip is the name of the file and we can change this to any other name

 */


public class Demo5_TraceViewver
{
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(false));

            Page page = context.newPage();
            page.navigate("https://www.facebook.com/");
            page.getByTestId("cookie-policy-manage-dialog-accept-button").click();
            page.getByTestId("open-registration-form-button").click();

            page.getByPlaceholder("First name").fill("Siddeshwar");
            page.getByLabel("Last name").fill("Gowda");
            page.getByLabel("Mobile number or email").fill("1524363545");
            page.getByLabel("New password").fill("siddugowda");
            page.getByLabel("Month").selectOption("5");
            page.getByLabel("Day").selectOption("10");
            page.getByLabel("Year").selectOption("1993");
            page.getByLabel("Male", new Page.GetByLabelOptions().setExact(true)).check();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign Up")).click();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("ArmanDemo.zip")));

            playwright.close();

        }
    }
}