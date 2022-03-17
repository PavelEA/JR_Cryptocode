package com.javarush.cryptoanalyser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CaesarEncryption {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    //static final int smeshenie = ForTheUser.getKey();



    public static ArrayList<Character> setCaesarCipher(ArrayList<Character> textFile, int offset) {
        ArrayList<Character> fileToWrite = new ArrayList<>(textFile);
        for (int i = 0; i < textFile.size(); i++) {
            char a = textFile.get(i);
            for (int j = 0; j < ALPHABET.length; j++) {
                if (a == ALPHABET[j]) {
                    fileToWrite.set(i, ALPHABET[(j + offset) % ALPHABET.length]);
                }
            }

        }
        return fileToWrite;
    }


    public static void dataCollection() {
        Scanner scanner = new Scanner(System.in);
        String originalFileLocationAddress;
        int offset = 0;
        String ciphertextFileAddress;
        System.out.println("Введите необходимый для шифра сдвиг: ");


            try {
                offset = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Вы ввели не число. Попробуйте вновь" + e);
                dataCollection();
            }
            System.out.println("Введите адрес оригинального файла: ");

            try {
                originalFileLocationAddress = scanner.nextLine();
                Path path = Paths.get(originalFileLocationAddress);
                if (!FileOptions.fileExist(path)) {
                    throw new Exception();
                }
                System.out.println("Введите адрес для сохранения зашифрованного файла: ");
                try {
                    ciphertextFileAddress = scanner.nextLine();
                    Path path1 = Paths.get(ciphertextFileAddress);
                    if (!FileOptions.fileExist(path1)) {
                        throw new Exception();
                    }
                    if (FileOptions.equals(originalFileLocationAddress,ciphertextFileAddress)){
                        System.out.println("Адрес для записи не может совпадать с адресом оригинального файла. Введите пожалуйста другой. ");
                    }

                } catch (Exception e) {
                    System.out.println("Ошибка ввода. Вы ввели не корректный адрес для записи. Попробуйте вновь" + e);
                    dataCollection();
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Вы ввели не корректный адресс. Попробуйте вновь" + e);
                dataCollection();
            }


       /* System.out.println("Введите адрес для сохранения зашифрованного файла: ");
        try {
            ciphertextFileAddress = scanner.nextLine();
            Path path = Paths.get(ciphertextFileAddress);
            if (!FileOptions.fileExist(path)) {
                throw new Exception();
            }
            if (FileOptions.equals(originalFileLocationAddress,ciphertextFileAddress)){

            }

        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес для записи. Попробуйте вновь" + e);
            dataCollection();
        }*/

        //setCaesarCipher(FileOptions.readFiles(originalFileLocationAddress),offset);
        //FileOptions.fileExist((ciphertextFileAddress));
        //метод для записи шифра(ciphertextFileAddress)

    }

}

