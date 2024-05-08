package com.msbkn.ui.common.pages;

import com.msbkn.core.model.Person;
import com.msbkn.core.service.PersonFileManager;
import com.msbkn.core.service.PersonService;
import com.msbkn.ui.common.components.PrLabelHtmlField;
import com.msbkn.ui.common.components.PrSelectButton;
import com.msbkn.ui.pages.components.PersonCart;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends HorizontalLayout {
    public Header() {
        setMargin(true);
        setSpacing(true);
        setSizeFull();
        builderHeaderLayout();
    }

    public PrSelectButton btnSelectName;

    private void builderHeaderLayout() {

        String htmlString = "<center><H1 style='color:blue'> PERSONEL WEB UYGULAMASI</H1></center>";
        PrLabelHtmlField lblHeaderText = new PrLabelHtmlField(htmlString);
        lblHeaderText.setStyleName("center");
        addComponent(lblHeaderText);

        btnSelectName = new PrSelectButton();
        btnSelectName.addStyleName(ValoTheme.BUTTON_LINK);
        btnSelectName.setCaption("Kullanıcı Adı : Boş");
        btnSelectName.addClickListener(event -> {
            showWindowField(event);
        });
        addComponent(btnSelectName);

        setComponentAlignment(btnSelectName, Alignment.TOP_CENTER);
        setComponentAlignment(lblHeaderText, Alignment.TOP_RIGHT);


    }

    private void showWindowField(Button.ClickEvent event) {
        String captionStr = event.getButton().getCaption();

        int beginIndex = captionStr.indexOf("[") + 1;
        int endIndex = captionStr.indexOf("]");

        if (endIndex == -1)
            return;

        String substring = captionStr.substring(beginIndex, endIndex);

        long selectItem = new Long(substring);

        PersonService personService = new PersonFileManager();
        Person person = personService.findPersonById(selectItem);

        PersonCart personCartPage = new PersonCart(person);
        personCartPage.buildLayout();

    }


}
