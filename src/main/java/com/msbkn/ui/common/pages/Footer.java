package com.msbkn.ui.common.pages;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class Footer extends VerticalLayout {
    public Footer() {
        setSizeFull();
        buildFooterLayout();
    }

    private void buildFooterLayout() {
        String htmlString = "<center><H3>@Copyright - By Musab Akan</H3></center>";
        Label lblFooterField = new Label();
        lblFooterField.setContentMode(ContentMode.HTML);
        lblFooterField.setValue(htmlString);
        addComponent(lblFooterField);
    }
}
