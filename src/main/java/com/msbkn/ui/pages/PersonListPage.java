package com.msbkn.ui.pages;

import com.msbkn.core.model.Person;
import com.msbkn.core.service.PersonFileManager;
import com.msbkn.core.service.PersonService;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class PersonListPage extends VerticalLayout {
    Table tblData;
    PersonService service;

    public PersonListPage() {
        setSizeFull();
        setSpacing(true);
        setMargin(true);
        buildTableField();

    }

    private void buildTableField() {
        tblData = new Table();

        tblData.setSizeFull();
        tblData.setSelectable(true);

        tblData.addContainerProperty("id", Long.class, null);
        tblData.addContainerProperty("name", String.class, null);

        fillData();



        addComponent(tblData);
    }

    private void fillData() {
        tblData.removeAllItems();
        service = new PersonFileManager();

        List<Person> personList = service.fillPersons();

        if (personList == null)
            return;

        for (Person person : personList) {
            addItemToTable(person);
        }

    }

    private void addItemToTable(Person person) {
        tblData.addItem(person);

        long idField = person.getId();
        tblData.getContainerProperty(person, "id").setValue(idField);

        String nameField = person.getName();
        tblData.getContainerProperty(person, "name").setValue(nameField);


    }
}
