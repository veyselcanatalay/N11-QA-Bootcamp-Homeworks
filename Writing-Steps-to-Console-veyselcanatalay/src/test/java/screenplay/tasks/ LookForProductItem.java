package screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import screenplay.user_interface.SearchPageElements;

public class LookForProductItem {
    public static Performable about(String term) {
        return Task.where("{0} look for the "+ term,
                Click.on(SearchPageElements.SEARCH_FIELD),
                SendKeys.of(term).into(SearchPageElements.SEARCH_FIELD)
                        .thenHit(Keys.ENTER));
    }
}