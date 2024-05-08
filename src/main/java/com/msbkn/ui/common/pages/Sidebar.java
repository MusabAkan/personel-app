package com.msbkn.ui.common.pages;

import com.msbkn.ui.pages.PersonListPage;
import com.msbkn.ui.pages.PersonSavePage;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class Sidebar extends VerticalLayout {
    private Tree listChildrenTree;
    private Content content;

    private String managerOperStr = "Yönetici İşlemleri";
    private String imagingOperStr = "Görüntüleme İşlemmleri";
    private String personSaveStr = "Personel Kaydet";
    private String personSearchStr = "Personel Ara";

    public Sidebar(Content content) {
        this.content = content;
        setMargin(true);
        setSpacing(true);
        builSidebarLayout();
    }

    private void builSidebarLayout() {

        listChildrenTree = new Tree();

        listChildrenTree.addItem(managerOperStr);
        listChildrenTree.addItem(imagingOperStr);
        listChildrenTree.addItem(personSaveStr);
        listChildrenTree.addItem(personSearchStr);

        listChildrenTree.setParent(personSaveStr, managerOperStr);
        listChildrenTree.setParent(personSearchStr, imagingOperStr);

        //areChildrenAllowed = parentes başka var mı ?
        listChildrenTree.setChildrenAllowed(personSaveStr, false);
        listChildrenTree.setChildrenAllowed(personSearchStr, false);


        selectedChildrenList();

        addComponent(listChildrenTree);
    }

    private void selectedChildrenList() {
        listChildrenTree.addItemClickListener(event -> {

            String selectedItemChildren = event.getItemId().toString();

            if (selectedItemChildren.equals(personSaveStr)) {

                PersonSavePage personSavePage = new PersonSavePage();
                content.removeAllComponents();
                content.addComponent(personSavePage);
            }
            if (selectedItemChildren.equals(personSearchStr)) {

                PersonListPage personListPage = new PersonListPage();
                content.removeAllComponents();
                content.addComponent(personListPage);

            }


        });
    }


}
