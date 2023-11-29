package com.saucedemo.utilities.user.questions.common;

import com.saucedemo.utilities.ui.components.items.ItemCard;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Collection;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TextOf {

    public static Question<String> the(Target target) {
        return Question.about("Text of " + target)
                .answeredBy(
                        user -> {
                            user.attemptsTo(WaitUntil.the(target, isVisible()));
                            return user.asksFor(Text.of(target).asString());
                        }
                );
    }

    public static Question<Collection<String>> allThe(Target target) {
        return Question.about("text of all " + target)
                .answeredBy(
                        user -> {
                            user.attemptsTo(WaitUntil.the(target, isVisible()));
                            return user.asksFor(Text.ofEach(target));
                        }
                );
    }
}
