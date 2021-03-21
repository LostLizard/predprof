package com.example.system.controllers.services;

import com.example.system.data.WorkWithData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AutoFillDB {

    @Autowired
    final static ThreadLocal<TempService> tempService = new ThreadLocal<TempService>();
    public static void main(String[] args) {
        ArrayList<Float> temps = new WorkWithData().takeGoodList("//media//nikita//Samsung_T5//sharedFiles//system//src//main//java//com//example//system//data//Западный.txt");
        for (int i = 0; i < temps.size(); i++) {
            tempService.get().addTemp(temps.get(i), null, 2l);
        }
    }
}