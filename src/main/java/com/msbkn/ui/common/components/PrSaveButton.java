package com.msbkn.ui.common.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class PrSaveButton extends Button {
    public PrSaveButton() {
        setIcon(FontAwesome.SAVE);
        addStyleName(ValoTheme.BUTTON_FRIENDLY);
    }
}