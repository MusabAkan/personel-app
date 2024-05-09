package com.msbkn.ui.pages;

import com.msbkn.core.model.Person;
import com.msbkn.core.service.PersonFileManager;
import com.msbkn.core.service.PersonService;
import com.msbkn.ui.common.components.PrTextField;
import com.msbkn.ui.common.pages.Header;
import com.vaadin.data.Container;
import com.vaadin.data.util.filter.Like;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class PersonListPage extends VerticalLayout {
    private PersonService service;

    private String idStr = "id";
    private String nameStr = "name";

    private Header header;
    private Table tblData;
    private PrTextField idFilterField;
    private PrTextField nameFilterField;

    private VerticalLayout verticalLayout;
    private FormLayout filterLayout;

    public PersonListPage(Header header) {
        this.header = header;

        verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        verticalLayout.setSizeFull();
        verticalLayout.setMargin(true);

        buildFilterFormLayout();
        verticalLayout.addComponent(filterLayout);

        buildTableField();
        verticalLayout.addComponent(tblData);

        addComponent(verticalLayout);

    }

    private void buildFilterFormLayout() {

        filterLayout = new FormLayout();

        idFilterField = new PrTextField();
        idFilterField.setCaption("Id Ara..");
        idFilterField.addTextChangeListener(event -> {
            String searchIdField = event.getText();
            filterSearch(searchIdField, idStr);
        });

        filterLayout.addComponents(idFilterField);


        nameFilterField = new PrTextField();
        nameFilterField.setCaption("İsmi Ara...");
        nameFilterField.addTextChangeListener(event -> {
            String searchNameField = event.getText();
            filterSearch(searchNameField, nameStr);
        });

        filterLayout.addComponent(nameFilterField);

    }

    private void buildTableField() {
        tblData = new Table();

        tblData.setSizeFull();
        tblData.setSelectable(true);

        tblData.addContainerProperty(idStr, String.class, null);
        tblData.addContainerProperty(nameStr, String.class, null);

        fillData();

        selectPersonData();
    }

    private void selectPersonData() {
        tblData.addItemClickListener(event -> {
            Person person = (Person) event.getItemId();
            header.updateViewByPerson(person);
        });
    }

    private void fillData() {
        tblData.removeAllItems();
        service = new PersonFileManager();

        List<Person> personList = service.readAllPersonFromFile();

        if (personList == null) return;

        for (Person person : personList) {
            addItemToTable(person);
        }
    }

    private void addItemToTable(Person person) {
        tblData.addItem(person);

        String idField = String.valueOf(person.getId());
        tblData.getContainerProperty(person, idStr).setValue(idField);

        String nameField = person.getName();
        tblData.getContainerProperty(person, nameStr).setValue(nameField);
    }

    private void filterSearch(String filterString, String columnName) {
        Container.Filterable filter = (Container.Filterable) (tblData.getContainerDataSource());
        filter.removeAllContainerFilters();
        if (filterString.length() > 0)
            filter.addContainerFilter(new Like(columnName, "%" + filterString + "%"));
    }
}
