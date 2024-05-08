package com.msbkn.ui.pages;

import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class PersonListPage  extends VerticalLayout {
    Table tblData;


    public PersonListPage() {
        setSizeFull();
        setSpacing(true);
        setMargin(true);
        buildFormLayout();

    }

    private void buildFormLayout() {
        tblData = new Table();

        tblData.setSizeFull();

        tblData.addContainerProperty("id", String.class, null);
        tblData.addContainerProperty("name", String.class, null);

        addComponent(tblData);
    }
}
