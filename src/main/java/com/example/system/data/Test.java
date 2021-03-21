package com.example.system.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Float> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\predprof\\src\\main\\java\\com\\example\\system\\data\\Алмазный.txt"));){
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
                miniList = new ArrayList<>();
            }
        }
        System.out.println(countOfRemove);
    }
}
