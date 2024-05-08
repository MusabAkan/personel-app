package com.msbkn.ui;

import javax.servlet.annotation.WebServlet;

import com.msbkn.ui.pages.Body;
import com.msbkn.ui.pages.Footer;
import com.msbkn.ui.pages.Header;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.msbkn.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();

        layout.setSizeFull();

        Header header = new Header();
        layout.setExpandRatio(header,0.5f);
        layout.addComponent(header);

        Body body = new Body();
        layout.setExpandRatio(body, 2f);
        layout.addComponent(body);

        Footer footer = new Footer();
        layout.setExpandRatio(footer, 0.5f);
        layout.addComponent(footer);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
