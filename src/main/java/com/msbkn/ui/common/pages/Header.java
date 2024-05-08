package com.msbkn.ui.common.pages;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends HorizontalLayout {
    public Header() {
        setMargin(true);
        setSpacing(true);
        setSizeFull();
        builderHeaderLayout();
    }

    private void builderHeaderLayout() {

        Label lblHeaderText = new Label();
        String htmlString = "<center><H1>PERSONEL PROGRAMI</H1></center>";
        lblHeaderText.setStyleName("center");

        lblHeaderText.setContentMode(ContentMode.HTML);
        lblHeaderText.setValue(htmlString);
        addComponent(lblHeaderText);


        Button btnSelectName = new Button();
        btnSelectName.addStyleName(ValoTheme.BUTTON_LINK);
        btnSelectName.setCaption("Kullanıcı Adı : ");
        addComponent(btnSelectName);

        setComponentAlignment(btnSelectName, Alignment.TOP_CENTER);
        setComponentAlignment(lblHeaderText, Alignment.TOP_RIGHT);



    }





}
