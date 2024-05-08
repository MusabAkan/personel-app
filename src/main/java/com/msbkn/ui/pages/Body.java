package com.msbkn.ui.pages;

import com.vaadin.ui.HorizontalLayout;

public class Body extends HorizontalLayout {
    Content content;
    Sidebar sidebar;

    public Body() {
        setSizeFull();
        buidContentLayout();
    }

    private void buidContentLayout() {
        content = new Content();
        sidebar = new Sidebar(content);

        addComponent(sidebar);
        addComponent(content);

        setExpandRatio(sidebar, 0.2f);
        setExpandRatio(content, 0.8f);
    }
}
