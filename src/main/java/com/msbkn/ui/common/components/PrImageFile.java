package com.msbkn.ui.common.components;

import com.vaadin.server.FileResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PrImageFile implements Upload.Receiver, Upload.SucceededListener {
    public File file;

    final Embedded image = new Embedded("Resim Yükle *.png |.jpeg ");

    public OutputStream receiveUpload(String filename, String mimeType) {

        if (!mimeType.equals("image/jpeg") && !mimeType.equals("image/png")) {
            return null;
        }

        FileOutputStream fos = null;
        try {

            file = new File("C:/uploads/" + filename);
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            new Notification("Dosya bulunamadı hacii");
            return null;
        }
        return fos;
    }


    @Override
    public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {

        image.setVisible(true);
        image.setSource(new FileResource(file));
    }
}


