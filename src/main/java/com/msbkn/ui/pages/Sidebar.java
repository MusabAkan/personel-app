package com.msbkn.ui.pages;

import com.msbkn.ui.common.components.LbSidebarButton;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.VerticalLayout;

public class Sidebar extends VerticalLayout {
    private LbSidebarButton lbSidebarButton;
    private Content contentPage;

    public Sidebar(Content contentPage) {
        this.contentPage = contentPage;

        setMargin(true);
        setSpacing(true);
        builSidebarLayout();
    }

    private void builSidebarLayout() {
    }


}
