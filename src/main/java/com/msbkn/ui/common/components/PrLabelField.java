package com.msbkn.ui.common.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class PrLabelField extends Label {
    public PrLabelField() {
        addStyleName(ValoTheme.LABEL_COLORED);
        addStyleName(ValoTheme.LABEL_H1);
    }
}
