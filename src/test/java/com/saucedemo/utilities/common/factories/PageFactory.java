package com.saucedemo.utilities.common.factories;

import com.saucedemo.utilities.ui.pages.LoginPage;
import com.saucedemo.utilities.ui.pages.ProductsPage;
import com.saucedemo.utilities.ui.pages.YourCartPage;
import com.saucedemo.utilities.ui.pages.checkout.CheckoutCompletePage;
import com.saucedemo.utilities.ui.pages.checkout.CheckoutOverviewPage;
import com.saucedemo.utilities.ui.pages.checkout.CheckoutYourInformationPage;
import net.serenitybdd.core.pages.PageObject;

public class PageFactory {

    public static PageObject getPage(String pageName) {
        switch (pageName.toLowerCase()) {
            case "login":
                return new LoginPage();
            case "products":
                return new ProductsPage();
            case "your cart":
                return new YourCartPage();
            case "checkout: your information":
                return new CheckoutYourInformationPage();
            case "checkout: overview":
                return new CheckoutOverviewPage();
            case "checkout: complete!":
                return new CheckoutCompletePage();
            default: throw new IllegalArgumentException(pageName + " page is not defined");
        }
    }
}
