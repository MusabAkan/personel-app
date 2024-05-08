package com.msbkn.ui.pages;

import com.msbkn.ui.common.components.LbLabelField;
import com.vaadin.ui.VerticalLayout;

public class Header extends VerticalLayout {
    LbLabelField lbLabelField;
    public Header() {
        buildHeaderLayout();
        setMargin(true);
        setSpacing(true);
    }

    private void buildHeaderLayout() {

        lbLabelField = new LbLabelField();
        lbLabelField.setCaption("Kütüphan Programı V5");
        addComponent(lbLabelField);
    }
}
