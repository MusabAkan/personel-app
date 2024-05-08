package com.msbkn.ui.common.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class PrSelectButton extends Button {
    public PrSelectButton() {
        setIcon(FontAwesome.NAVICON);
        addStyleName(ValoTheme.BUTTON_PRIMARY);
    }
}
