package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.selleroffice.tasks.NavigateToSelleroffice;
import starter.selleroffice.tasks.SellerofficeSignUp;
import starter.selleroffice.tasks.user_interface.SellerofficeSignUpPageElements;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SellerofficeStepDefinitions {

    Actor actor = Actor.named("VeyselCan");
    @Managed
    WebDriver webDriver;

    @Given("VeyselCan launchs browser and opens the login page")
    public void veyselOpensLoginPage() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateToSelleroffice.theSelleroffice());
    }

    @When("VeyselCan signs up selleroffice with valid credentials")
    public void veyselSignsUp() {
        actor.attemptsTo(SellerofficeSignUp.signUp("veyselcanatalay","123654", "123654","veyselcanatalay@gmail.com", "veyselcanatalay@gmail.com", "TestShop"));


    }

    @And("avoids the contract agreement")

    @Then("VeyselCan should not be signed up")
    public void veyselShouldSeeErrorMessage() {
        actor.should(
                GivenWhenThen.seeThat(the(SellerofficeSignUpPageElements.ERROR_MESSAGE)
                        ,containsText("Lütfen sözleşmeyi kabul ettiğinizi onaylayın."))
        );
    }
}