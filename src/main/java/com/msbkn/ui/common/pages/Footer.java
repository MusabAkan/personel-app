package com.msbkn.ui.common.pages;

import com.msbkn.ui.common.components.PrLabelHtmlField;
import com.vaadin.ui.VerticalLayout;

public class Footer extends VerticalLayout {
    public Footer() {
        setSizeFull();
        buildFooterLayout();
    }

    private void buildFooterLayout() {
        String htmlString = "<center><H2 style='color:green'>@Copyright | By Musab Akan</H2></center>";
        PrLabelHtmlField lblFooterField = new PrLabelHtmlField(htmlString);
        addComponent(lblFooterField);
    }
}
