package com.javarush.cryptoanalyser;

import sun.java2d.pipe.AAShapePipe;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOptions {
    //Пример файл оригинальный: ./scr/java/com/javarush/cryptoanalyser/input.txt
    //Пример файл для записи: C:\Users\Pashok\IdeaProjects\JavaRush_Crypto\scr\java\com\javarush\cryptoanalyser\someText.txt
    private static final String FILE_NOT_FOUND_EXEPTION = " 1111111 Файл указаному адресу не существует или вы ввели не корректный адрес";
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
        } catch (Exception e) {
            System.out.println("Ошибка " + e);
            CaesarEncryption.doCaesarCipher();
        }
        return textFile;
    }

    public static void writeFiles(ArrayList<Character> textForWrite, String addressForWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(addressForWrite))) {
            for (char c : textForWrite) {
                bufferedWriter.write(c);
            }
        } catch (Exception e) {
            System.out.println(OUTPUT_FILE_NOT_FOUND);
        }
    }
}
