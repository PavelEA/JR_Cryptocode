package com.javarush.cryptoanalyser.brute_force;

import com.javarush.cryptoanalyser.file_options.FileOptions;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BruteForce extends FileOptions {
    public static final char[] ALPHABET = FileOptions.getALPHABET();

    public static void doBruteForce() {
        FileOptions.writeFiles(hackBruteForce(readFiles(getRepresentativeFileAddress())), getOriginalFileLocationAddress());

    }

    public static ArrayList<Character> hackBruteForce(ArrayList<Character> arrayFromFile) {
        ArrayList<Character> someTextArray = new ArrayList<>();
        for (int key = 1; key < ALPHABET.length; key++) { // беру ключ(сдвиг),
            for (Character s : arrayFromFile) {//с этим ключом прохожу по всему листу
                char[] chars = Character.toChars(s);//записываю значения листа в массив ====(массив с оригинал текстом)
                for (int i = 0; i < chars.length; i++) {//прохожу по массиву
                    char a = chars[i];
                    for (int j = 0; j < ALPHABET.length; j++) {// прохожу по алфавиту
                        char c = ALPHABET[j];
                        if (c == a) { // если сиволы равны
                            int bias = (j - key) % ALPHABET.length;
                            if (bias < 0) {
                                bias = bias + ALPHABET.length;


                            }
                            chars[i] = ALPHABET[bias];

                        }
                    }


                }
                for (char newChar : chars) { // в лист записали один из вариантов текста со смещением key
                    someTextArray.add(newChar);

                    for (int i = 0; i < chars.length; i++) {

                    }


                }


            }
            someTextArray.add('\n');

        }
        return someTextArray;


    }

        public static String getOriginalFileLocationAddress(){
            return FileOptions.getOriginalFileLocationAddress();
    }

    public static String getRepresentativeFileAddress() {

        return FileOptions.getRepresentativeFileAddress();
    }


    public static ArrayList<String> readFilesSplitAfter(String text) { // записал в лист каждую строку
        ArrayList<String> arrayString = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(text))) {
            while (bufferedReader.ready()) {
                String [] arrays = bufferedReader.readLine().split(" ");
                for (int i = 0; i < arrays.length; i++) {
                    arrayString.add(i,arrays[i]);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayString;
    }


    public static String writeFile1s(ArrayList<Character> textForWrite, String addressForWrite) { // новый который возвращает стрингу
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(addressForWrite))) {
            for (char c : textForWrite) {
                bufferedWriter.write(c);
            }
        } catch (Exception e) {
            System.out.println("Файл для записи не существует. Попробуйте еще раз");
        }
        return addressForWrite;
    }
}