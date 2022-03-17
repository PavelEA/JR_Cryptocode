package com.javarush.cryptoanalyser;

import sun.java2d.pipe.AAShapePipe;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOptions {
    static String abc = ForTheUser.getFilePath();//"./scr/java/com/javarush/cryptoanalyser/input.txt";
    private static final String FILE_NOT_FOUND_EXEPTION = " Файл указаному адресу не существует или вы ввели не корректный адрес";
    private static final String OUTPUT_FILE_NOT_FOUND = "Файл для записи не существует. Попробуйте еще раз";

    public static ArrayList<Character> readFiles(String file) {
        ArrayList<Character> textFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                char[] chars = bufferedReader.readLine().toCharArray();
                for (char c : chars) {
                    textFile.add(c);
                }
            }


        } catch (IOException e) {
            System.out.println(FILE_NOT_FOUND_EXEPTION);
            CaesarEncryption.dataCollection();


        }
        System.out.println(textFile);
        return textFile;

    }

    public static boolean fileExist(Path fileName) {
        return Files.exists(fileName);
    }

    public static boolean equals(String a, String b){
        return a.equals(b);
    }

}
