package starter.selleroffice.tasks.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SellerofficeSignUpPageElements {

    public static Target USERNAME_FIELD = Target.the("username field").located(By.id("usernameInputText"));
    public static Target PASSWORD_FIELD = Target.the("password field").located(By.id("passwordInputText"));
    public static Target PASSWORD_RETYPE_FIELD = Target.the("password retype field").located(By.id("passwordRetypeInputText"));
    public static Target EMAIL_FIELD = Target.the("email field").located(By.id("emailInputText"));
    public static Target EMAIL_RETYPE_FIELD = Target.the("email retype field").located(By.id("emailRetypeInputText"));
    public static Target SHOPNAME_FIELD = Target.the("shopname field").located(By.id("nicknameInputText"));
    public static Target REGISTER_BUTTON = Target.the("register button").located(By.id("loginCommandButton"));
    public static Target ERROR_MESSAGE = Target.the("error message").located(By.id("j_id261_j_id_cy"));

}