package com.javarush.cryptoanalyser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {
    final int smeshenie = 2;
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String abc = "./scr/java/com/javarush/cryptoanalyser/input.txt";
        String fileName = scanner.nextLine();

        System.out.println(ReadFiles(abc));



    }


    public static ArrayList<Character> setCaesarCipher(ArrayList<String> textFile,int smeshenie) {
        ArrayList<Character> newTextFile = new ArrayList<>();
        for (int i = 0; i < textFile.size(); i++) {
            if (textFile.get(i).equals(valueOf(ALPHABET[i])))
            newTextFile.add(i,ALPHABET[i+smeshenie]);
        }
        return newTextFile;
    }


    public static ArrayList<String> ReadFiles(String file) {
        ArrayList<String> textFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                textFile.add(bufferedReader.readLine());
            }
            return textFile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textFile;
    }

    public void fileExist(String file){

    }
}
