package com.msbkn.ui.common.components;

import com.vaadin.ui.TextField;

public class PrNumericField extends TextField {
    public PrNumericField() {
        numericValidValue();
    }

    private void numericValidValue() {
        addTextChangeListener(event -> {

            String text = event.getText();
            int index = text.length() - 1;
            if (index == -1)
                return;

            char charAt = text.charAt(index);
            int ascii = (int) charAt;

            if (ascii < 48 || ascii > 57) {
                this.setValue("");
            }
        });
    }
}