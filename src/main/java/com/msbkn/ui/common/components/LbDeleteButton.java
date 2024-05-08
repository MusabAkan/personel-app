package com.msbkn.ui.common.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class LbDeleteButton extends Button {
    public LbDeleteButton() {
        setIcon(FontAwesome.TRASH);
        setStyleName(ValoTheme.BUTTON_DANGER);
    }

}
