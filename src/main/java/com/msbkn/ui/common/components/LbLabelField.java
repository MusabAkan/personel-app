package com.msbkn.ui.common.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class LbLabelField extends Label {
    public LbLabelField() {
        addStyleName(ValoTheme.LABEL_COLORED);
        addStyleName(ValoTheme.LABEL_H1);
    }
}
