package com.msbkn.ui.common.pages;

import com.msbkn.core.model.Person;
import com.msbkn.core.service.PersonFileManager;
import com.msbkn.core.service.PersonService;
import com.msbkn.ui.MyUI;
import com.msbkn.ui.common.components.PrLabelHtmlField;
import com.msbkn.ui.common.components.PrSelectButton;
import com.msbkn.ui.pages.components.PersonCardWindow;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends HorizontalLayout {

    private PrSelectButton btnSelectName;
    private Person selectedPerson = null;

    public Header() {
        setMargin(true);
        setSpacing(true);
        setSizeFull();
        builderHeaderLayout();
    }

    private void builderHeaderLayout() {

        String htmlString = "<center><H1 style='color:blue'> PERSONEL WEB UYGULAMASI</H1></center>";
        PrLabelHtmlField lblHeaderText = new PrLabelHtmlField(htmlString);
        lblHeaderText.setStyleName("center");
        addComponent(lblHeaderText);

        btnSelectName = new PrSelectButton();
        btnSelectName.addStyleName(ValoTheme.BUTTON_LINK);
        btnSelectName.setCaption("Kullanıcı Adı : Boş");
        btnSelectName.addClickListener(event -> showWindowField());
        addComponent(btnSelectName);

        setComponentAlignment(btnSelectName, Alignment.TOP_CENTER);
        setComponentAlignment(lblHeaderText, Alignment.TOP_RIGHT);
    }

    private void showWindowField() {
        if (selectedPerson == null) return;
        long personId = selectedPerson.getId();

        PersonService personService = new PersonFileManager();
        Person person = personService.findPersonById(personId);

        PersonCardWindow personCardWindow = new PersonCardWindow(person);
        MyUI.getCurrent().addWindow(personCardWindow);
    }

    public void updateViewByPerson(Person person) {
        String captionStr = "Kullanıcı Adı : [" + person.getId() + "] " + person.getName();
        btnSelectName.setCaption(captionStr);
        selectedPerson = person;
    }
}