package com.msbkn.ui.common.components;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class PrLabelHtmlField extends Label {
    public PrLabelHtmlField(String htmlText) {
        setContentMode(ContentMode.HTML);
        setValue(htmlText);
    }
}
