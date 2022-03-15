package com.javarush.cryptoanalyser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Main {
    static String abc = "./scr/java/com/javarush/cryptoanalyser/input.txt";
    static final int smeshenie = 2;
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'',':', '!', '?',' ' };

    public static void main(String[] args) {




        System.out.println();



    }


    public static ArrayList<Character> setCaesarCipher(ArrayList<Character> textFile, int offset) {
        ArrayList<Character> fileToWrite = new ArrayList<>(textFile);
        for (int i = 0; i < textFile.size(); i++) {
            char a = textFile.get(i);
            for (int j = 0; j < ALPHABET.length ; j++) {
                if(a == ALPHABET[j]){
                    fileToWrite.set(i, ALPHABET[j + offset]);
                }
            }

        }
        return fileToWrite;
    }


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
