package starter.selleroffice.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.cocoads.tasks.user_interface.CocoAdsHomePage;
import starter.selleroffice.tasks.user_interface.SellerofficeHomePage;

public class NavigateToSelleroffice {
    public static Performable theSelleroffice() {
        return Task.where("{0} opens the seller office login page",
                Open.browserOn().the(SellerofficeHomePage.class));
    }
}