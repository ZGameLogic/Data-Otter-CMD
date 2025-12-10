package com.zgamelogic;

import com.zgamelogic.app.DataOtterModel;
import com.zgamelogic.app.DataOtterService;
import com.zgamelogic.app.GUI;

public class Main {
    public static void main(String[] args) {
        DataOtterService service = new DataOtterService();
        DataOtterModel model = new DataOtterModel(service);
        new GUI(model);
    }
}