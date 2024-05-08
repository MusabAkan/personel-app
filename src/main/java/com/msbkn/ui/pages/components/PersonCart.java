package com.msbkn.ui.pages.components;

import com.msbkn.core.model.Person;
import com.msbkn.ui.MyUI;
import com.msbkn.ui.common.components.PrTextField;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;

import java.io.File;

public class PersonCart extends Window {
    private Person person;
    private Window windowShow;

    public PersonCart(Person person) {
        this.person = person;
    }

    public void buildLayout() {
        MyUI ui = (MyUI) UI.getCurrent();

        windowShow = new Window();
        windowShow.setModal(true);
        windowShow.setWidth("30%");
        windowShow.setHeight("35%");
        windowShow.center();

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);

        windowShow.setContent(horizontalLayout);

        String imagePath = person.getImagePath();
        FileResource resource = new FileResource(new File(imagePath));
        Image imageComponent = new Image("RESİM", resource);
        imageComponent.setHeight("250px");
        imageComponent.setWidth("250px");
        horizontalLayout.addComponent(imageComponent);

        FormLayout formLayout = new FormLayout();

        PrTextField idPrTextField = new PrTextField();
        idPrTextField.setCaption("ID : ");
        String idField = String.valueOf(person.getId());
        idPrTextField.setValue(idField);
        formLayout.addComponent(idPrTextField);


        PrTextField namPrTextField = new PrTextField();
        namPrTextField.setCaption("Adı : ");
        String nameField = person.getName();
        namPrTextField.setValue(nameField);
        formLayout.addComponent(namPrTextField);

        horizontalLayout.addComponent(formLayout);

        horizontalLayout.setExpandRatio(imageComponent, 0.6f);
        horizontalLayout.setExpandRatio(formLayout, 0.4f);

        ui.addWindow(windowShow);
    }
}
