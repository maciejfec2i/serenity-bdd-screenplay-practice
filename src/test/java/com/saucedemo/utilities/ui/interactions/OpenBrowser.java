package com.saucedemo.utilities.ui.interactions;

import com.saucedemo.utilities.common.Browser;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.PageUrls;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.SilentTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenBrowser {

    public static Performable on(String url) {
        return Task.where(
                "{0} opens the browser on " + url,
                user -> {
                    String currentUrl = Browser.currentUrl();
                    if(!currentUrl.equals(url)) {
                        user.attemptsTo(
                                SilentTask.where(
                                        Open.url(url)
                                )
                        );
                    }
                }
        );
    }

    public static Performable on(PageObject targetPage) {
        PageUrls pageUrls = new PageUrls(targetPage);
        String targetUrl = targetPage.updateUrlWithBaseUrlIfDefined(pageUrls.getStartingUrl());
        return Task.where(
                "{0} opens the browser on the " + targetPage + " with the url of " + targetUrl,
                user -> {
                    String currentUrl = Browser.currentUrl();
                    if(!currentUrl.equals(targetUrl)) {
                        user.attemptsTo(
                                SilentTask.where(
                                        Open.browserOn(targetPage)
                                )
                        );
                    }
                }
        );
    }
}
