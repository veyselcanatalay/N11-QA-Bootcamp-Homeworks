package starter.selleroffice.tasks.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SellerofficeHomePageElements {
    public static Target SIGNUP_BUTTON =
            Target.the("signup button")
                    .located(By.id("registerNow"));

}