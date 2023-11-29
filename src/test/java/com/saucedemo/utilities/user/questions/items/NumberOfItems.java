package com.saucedemo.utilities.user.questions.items;

import com.saucedemo.utilities.ui.components.items.ItemCard;
import com.saucedemo.utilities.user.questions.common.TextOf;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Collection;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NumberOfItems {

    public static Question<Integer> inCart() {
        return Question.about("total number of items currently in the cart")
                .answeredBy(
                        user -> {
                            user.attemptsTo(WaitUntil.the(ItemCard.INVENTORY_ITEM_NAME, isVisible()));
                            return user.asksFor(TextOf.allThe(ItemCard.INVENTORY_ITEM_NAME)).size();
                        }
                );
    }
}
