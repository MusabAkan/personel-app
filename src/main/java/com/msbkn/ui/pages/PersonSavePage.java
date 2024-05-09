package com.msbkn.ui.pages;

import com.msbkn.core.model.Person;
import com.msbkn.core.service.PersonFileManager;
import com.msbkn.core.service.PersonService;
import com.msbkn.ui.common.components.*;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class PersonSavePage extends VerticalLayout {

    private PrSaveButton saveButton;
    private PrImageUpload prImageUpload;
    private PrImageFile imageFile;
    private FormLayout formLayout;
    private PrNumericField idNumericField;
    private PrTextField nameTextField;

    public PersonSavePage() {
        setSizeFull();
        setSpacing(true);
        setMargin(true);
        buildFormLayout();
    }

    private void buildFormLayout() {
        formLayout = new FormLayout();

        buildTextNumericFielId();
        buildTextFieldName();
        buildUploadFieldImage();
        buildSaveButtonField();

        addComponent(formLayout);
    }

    private void buildSaveButtonField() {
        saveButton = new PrSaveButton();
        saveButton.setCaption("Kaydet");
        saveButton.addClickListener(clickEvent -> {
            savedItemPerson();
        });
        formLayout.addComponent(saveButton);
    }


    private void buildUploadFieldImage() {
        imageFile = new PrImageFile();
        prImageUpload = new PrImageUpload(imageFile);
        prImageUpload.addSucceededListener(imageFile);
        formLayout.addComponent(prImageUpload);
    }

    private void buildTextFieldName() {
        nameTextField = new PrTextField();
        nameTextField.setCaption("İsmi");
        formLayout.addComponent(nameTextField);
    }

    private void buildTextNumericFielId() {
        idNumericField = new PrNumericField();
        idNumericField.setCaption("Id");
        formLayout.addComponent(idNumericField);
    }

    private void savedItemPerson() {

        PersonService personService = new PersonFileManager();
        String idFieldStr = idNumericField.getValue();

        if (idFieldStr == null || idFieldStr == "") {
            Notification.show("Lütfen Id değerini giriniz..");
            return;
        }

        long idField = new Long(idFieldStr);
        String nameField = nameTextField.getValue();

        Person exist = personService.findPersonById(idField);
        if (exist != null) {
            Notification.show("Daha önce kaydedildi...");
            return;
        }

        String pathField = "";

        if (imageFile.file != null)
            pathField = imageFile.file.getPath();


        Person person = new Person(idField, nameField, pathField);

        boolean result = personService.savePerson(person);

        if (result)
            Notification.show("Veritabanına başarıllı bir şekilde eklenmiştir.");
        else
            Notification.show("Ekleme işlemi başarısız oldu!!");
    }
}
