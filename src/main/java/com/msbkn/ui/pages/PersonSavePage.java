package com.msbkn.ui.pages;

import com.msbkn.ui.common.components.*;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class PersonSavePage extends VerticalLayout {

    private PrSaveButton saveButton;
    private PrImageUpload prImageUpload;
    private PrImageFile imageFile;
    private FormLayout formLayout;
    private PrNumericField idField;
    private PrTextField nameField;

    public PersonSavePage() {
        setSizeFull();
        setSpacing(true);
        setMargin(true);
        buildFormLayout();
    }

    private void buildFormLayout() {
        formLayout = new FormLayout();

        idField = new PrNumericField();
        idField.setCaption("Id");
        formLayout.addComponent(idField);

        nameField = new PrTextField();
        nameField.setCaption("İsmi");
        formLayout.addComponent(nameField);

        imageFile = new PrImageFile();

        prImageUpload = new PrImageUpload(imageFile);
        prImageUpload.addSucceededListener(imageFile);
        formLayout.addComponent(prImageUpload);

        saveButton = new PrSaveButton();
        saveButton.setCaption("Kaydet");
        saveButton.addClickListener(clickEvent -> {
            savedItemPerson();
        });

        formLayout.addComponent(saveButton);


        addComponent(formLayout);
    }

    private void savedItemPerson() {

            long length = imageFile.file.length();
            Notification.show(String.valueOf(length));

    }
}
