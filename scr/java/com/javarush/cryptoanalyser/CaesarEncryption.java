package com.javarush.cryptoanalyser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CaesarEncryption {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '}; // сделать один на всех?

    public static ArrayList<Character> setCaesarCipher(ArrayList<Character> textFile, int offset) {
        ArrayList<Character> fileToWrite = new ArrayList<>(textFile);
        for (int i = 0; i < textFile.size(); i++) {
            char a = Character.toLowerCase(textFile.get(i));
            for (int j = 0; j < ALPHABET.length; j++) {
                if (a == ALPHABET[j]) {
                    fileToWrite.set(i, ALPHABET[(j + offset) % ALPHABET.length]);
                }
            }
        }
        return fileToWrite;
    }

    public static void writeCaesarCipher(ArrayList<Character> fileToWrite, String pathToWrite){
        FileOptions.writeFiles(fileToWrite,pathToWrite);
    }
    public static void doCaesarCipher(){
        writeCaesarCipher(setCaesarCipher(FileOptions.readFiles(getOriginalFileLocationAddress()),getOffset()),getCiphertextFileAddress());
    }//при вводе не правильного ориг пути просит по 2 раза сдвиг и расшифровку?

    public static int getOffset(){
        System.out.println("Введите необходимый для шифра сдвиг: ");
        Scanner scanner = new Scanner(System.in);
        int offset = 0;
        try {
                offset = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не число. Попробуйте вновь " + e);
            getOffset();
        }
        return offset;
    }

    public static String getOriginalFileLocationAddress(){
        Scanner scannerForOrg = new Scanner(System.in);
        System.out.println("Введите адрес оригинального файла: ");
        String originalFileLocationAddress = " ";
        try {
            originalFileLocationAddress = scannerForOrg.nextLine();
            File file = new File(originalFileLocationAddress).getAbsoluteFile();
            if (!file.exists()) {throw new Exception();}
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес. Попробуйте вновь " + e);
            getOriginalFileLocationAddress();
        }
        return originalFileLocationAddress;
    }

    public static String getCiphertextFileAddress(){
        Scanner scannerForCip = new Scanner(System.in);
        System.out.println("Введите адрес для сохранения зашифрованного файла: ");
        String ciphertextFileAddress = " ";
        try {
            ciphertextFileAddress = scannerForCip.nextLine();
            File file1 = new File(ciphertextFileAddress).getAbsoluteFile();
            if (!file1.exists()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес для записи. Попробуйте вновь" + e);
            getCiphertextFileAddress();
        }

        return ciphertextFileAddress;
    }



}

