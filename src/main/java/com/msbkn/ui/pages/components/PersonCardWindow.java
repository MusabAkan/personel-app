package com.msbkn.ui.pages.components;

import com.msbkn.core.model.Person;
import com.msbkn.ui.common.components.PrTextField;
import com.vaadin.server.FileResource;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Window;

import java.io.File;

public class PersonCardWindow extends Window {

    private Image imageComponent;
    private PrTextField idPrTextField;
    private PrTextField namPrTextField;

    public PersonCardWindow() {
        buildLayout();
    }

    public PersonCardWindow(Person person) {
        this();
        fillWindowByPerson(person);
    }

    private void buildLayout() {
        setModal(true);
        setWidth("30%");
        setHeight("35%");
        center();

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);

        setContent(horizontalLayout);

        imageComponent = new Image("RESİM");
        imageComponent.setHeight("250px");
        imageComponent.setWidth("250px");
        horizontalLayout.addComponent(imageComponent);

        FormLayout formLayout = new FormLayout();

        idPrTextField = new PrTextField();
        idPrTextField.setCaption("ID : ");
        formLayout.addComponent(idPrTextField);

        namPrTextField = new PrTextField();
        namPrTextField.setCaption("Adı : ");
        formLayout.addComponent(namPrTextField);

        horizontalLayout.addComponent(formLayout);

        horizontalLayout.setExpandRatio(imageComponent, 0.6f);
        horizontalLayout.setExpandRatio(formLayout, 0.4f);
    }

    public void fillWindowByPerson(Person person) {

        String imagePath = person.getImagePath();
        FileResource resource = new FileResource(new File(imagePath));
        imageComponent.setSource(resource);

        String idField = String.valueOf(person.getId());
        idPrTextField.setValue(idField);

        String nameField = person.getName();
        namPrTextField.setValue(nameField);
    }
}