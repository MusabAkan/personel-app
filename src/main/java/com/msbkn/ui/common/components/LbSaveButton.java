package com.msbkn.ui.common.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class LbSaveButton extends Button {
    public LbSaveButton() {
        setIcon(FontAwesome.SAVE);
        addStyleName(ValoTheme.BUTTON_FRIENDLY);
    }
}

