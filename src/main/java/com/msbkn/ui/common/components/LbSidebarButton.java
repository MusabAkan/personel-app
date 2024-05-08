package com.msbkn.ui.common.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class LbSidebarButton extends Button {
    public LbSidebarButton() {
        addStyleName(ValoTheme.BUTTON_LINK);
        addStyleName(ValoTheme.BUTTON_LARGE);
    }
}
