package com.example.system.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkWithData {
    public static ArrayList<Float> takeGoodList(String fileName){
        ArrayList<Float> list = new ArrayList<Float>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));){
            String strCurrentLine;
            reader.readLine();
            while ((strCurrentLine = reader.readLine()) != null) {
                list.add(Float.valueOf(strCurrentLine.replace(" ", "").replace(",", "")));
            }
            System.out.println(list.get(1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Float> miniList = new ArrayList<>();
        int count = 0;
        float sum = 0;
        int countOfRemove = 0;
        for (int i=0; i<list.size(); i++){
            count++;
            sum = sum +list.get(i);
            miniList.add(list.get(i));
            if (count==7){
                float srArfm = sum/7;
                for(int j=i; j<i+7; j++){
                    try {
                        if (Math.abs(list.get(j) - srArfm) >= 10) {
                            countOfRemove++;
                            list.remove(j);
                            list.add(j, srArfm);
                        }
                    } catch (IndexOutOfBoundsException e){

                    }
                }
                count = 0;
                sum = 0;
                miniList = new ArrayList<Float>();
            }
        }
        return list;
    }
}
