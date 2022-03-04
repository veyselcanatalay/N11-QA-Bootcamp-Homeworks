package starter.selleroffice.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import starter.selleroffice.tasks.user_interface.SellerofficeHomePageElements;
import starter.selleroffice.tasks.user_interface.SellerofficeSignUpPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static starter.selleroffice.tasks.user_interface.SellerofficeSignUpPageElements.ERROR_MESSAGE;

public class SellerofficeSignUp implements Task {

    private final String username_text;
    private final String password_text;
    private final String password2_text;
    private final String email_text;
    private final String email2_text;
    private final String shopname_text;

    public SellerofficeSignUp(String username_text, String password_text, String password2_text, String email_text, String email2_text, String shopname_text) {
        this.username_text = username_text;
        this.password_text = password_text;
        this.password2_text = password2_text;
        this.email_text = email_text;
        this.email2_text = email2_text;
        this.shopname_text = shopname_text;
    }

    public static Performable signUp(String username_text, String password_text, String password2_text, String email_text, String email2_text, String shopname_text) {
        return instrumented(starter.selleroffice.tasks.SellerofficeSignUp.class
                , username_text, password_text, password2_text, email_text, email2_text, shopname_text);
    }


    @Step("{0} sign up with username '#username_text', password '#password_text', password retype '#password2_text', email '#email_text', email retype '#email2_text' shop name '#shopname_text' ")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(SellerofficeHomePageElements.SIGNUP_BUTTON),
                WaitUntil.the(SellerofficeSignUpPageElements.USERNAME_FIELD, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(SellerofficeSignUpPageElements.USERNAME_FIELD),
                SendKeys.of(this.username_text).into(SellerofficeSignUpPageElements.USERNAME_FIELD),
                Click.on(SellerofficeSignUpPageElements.PASSWORD_FIELD),
                SendKeys.of(this.password_text).into(SellerofficeSignUpPageElements.PASSWORD_FIELD),
                Click.on(SellerofficeSignUpPageElements.PASSWORD_RETYPE_FIELD),
                SendKeys.of(this.password2_text).into(SellerofficeSignUpPageElements.PASSWORD_RETYPE_FIELD),
                Click.on(SellerofficeSignUpPageElements.EMAIL_FIELD),
                SendKeys.of(this.email_text).into(SellerofficeSignUpPageElements.EMAIL_FIELD),
                Click.on(SellerofficeSignUpPageElements.EMAIL_RETYPE_FIELD),
                SendKeys.of(this.email2_text).into(SellerofficeSignUpPageElements.EMAIL_RETYPE_FIELD),
                Click.on(SellerofficeSignUpPageElements.SHOPNAME_FIELD),
                SendKeys.of(this.shopname_text).into(SellerofficeSignUpPageElements.SHOPNAME_FIELD),
                Click.on(SellerofficeSignUpPageElements.REGISTER_BUTTON),
                Click.on(SellerofficeSignUpPageElements.REGISTER_BUTTON),
                Ensure.that(ERROR_MESSAGE).isDisplayed()
        );
    }

}