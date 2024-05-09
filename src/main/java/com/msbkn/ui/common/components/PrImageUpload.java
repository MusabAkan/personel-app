package com.msbkn.ui.common.components;

import com.vaadin.ui.Upload;

public class PrImageUpload extends Upload {
    public PrImageUpload( Receiver uploadReceiver) {
        super("Yüklenecek Dosya", uploadReceiver);
        setButtonCaption("Yükle...");
    }
}