package com.javarush.cryptoanalyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileOptions {
    static String abc = ForTheUser.getFilePath();//"./scr/java/com/javarush/cryptoanalyser/input.txt";

    public static ArrayList<Character> readFiles(String file) {
        ArrayList<Character> textFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while(bufferedReader.ready()){
                char [] chars = bufferedReader.readLine().toCharArray();
                for (char c : chars) {
                    textFile.add(c);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(textFile);
        return textFile;

    }

}
