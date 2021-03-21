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
    }
}
