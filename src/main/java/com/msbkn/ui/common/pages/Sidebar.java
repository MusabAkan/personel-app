package com.msbkn.ui.common.pages;

import com.msbkn.ui.pages.PersonListPage;
import com.msbkn.ui.pages.PersonSavePage;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class Sidebar extends VerticalLayout {
    private Tree ChildrenListTree;
    private Content content;
    private Header header;

    private String managerOperStr = "Yönetici İşlemleri";
    private String imagingOperStr = "Görüntüleme İşlemmleri";
    private String personSaveStr = "Personel Kaydet";
    private String personSearchStr = "Personel Ara";

    public Sidebar(Content content, Header header) {
        this.content = content;
        this.header = header;
        setMargin(true);
        setSpacing(true);
        builSidebarLayout();
    }

    private void builSidebarLayout() {

        ChildrenListTree = new Tree();

        ChildrenListTree.addItem(managerOperStr);
        ChildrenListTree.addItem(imagingOperStr);
        ChildrenListTree.addItem(personSaveStr);
        ChildrenListTree.addItem(personSearchStr);

        ChildrenListTree.setParent(personSaveStr, managerOperStr);
        ChildrenListTree.setParent(personSearchStr, imagingOperStr);

        //areChildrenAllowed = parentes başka var mı ?
        ChildrenListTree.setChildrenAllowed(personSaveStr, false);
        ChildrenListTree.setChildrenAllowed(personSearchStr, false);


        selectedChildrenList();

        addComponent(ChildrenListTree);
    }

    private void selectedChildrenList() {
        ChildrenListTree.addItemClickListener(event -> {

            String selectedItemChildren = event.getItemId().toString();

            if (selectedItemChildren.equals(personSaveStr)) {

                PersonSavePage personSavePage = new PersonSavePage();
                content.removeAllComponents();
                content.addComponent(personSavePage);
            }
            if (selectedItemChildren.equals(personSearchStr)) {

                PersonListPage personListPage = new PersonListPage(header);
                content.removeAllComponents();
                content.addComponent(personListPage);
            }
        });
    }


}
