package com.javarush.cryptoanalyser.decryption_by_caesar_method;

import com.javarush.cryptoanalyser.file_options.FileOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DecryptionByCaesarMethod extends FileOptions {
    public static final char[] ALPHABET = getALPHABET();

    public static void doDecryption()//при попытке сломать запрашивает по 2 раза сдвиг и адрес для файла
    {
    writeFiles(setDecryptionCaesar(readFile(),getOffset()),getOriginalFileLocationAddressС());
    }

    public static ArrayList<Character> setDecryptionCaesar(ArrayList<Character> textFile, int offset) {
        ArrayList<Character> fileToWrite = new ArrayList<>(textFile);
        for (int i = 0; i < textFile.size(); i++) {
            char a = Character.toLowerCase(textFile.get(i));
            for (int j = ALPHABET.length - 1; j > 0; j--) {
                if (a == ALPHABET[j]) {
                    int bias;
                    if (offset > 0) {
                        bias = (j - offset) % ALPHABET.length;
                    } else {
                        bias = (j + offset) % ALPHABET.length;
                    }
                    if (bias < 0) {
                        bias = bias + ALPHABET.length;

                    }
                    fileToWrite.set(i, ALPHABET[bias]);
                }
            }
        }
        return fileToWrite;
    }

    public static ArrayList<Character> readFile(){
        return FileOptions.readFiles(getCiphertextFileAddress());
    }



    public static String getOriginalFileLocationAddressС()
    {
        Scanner scannerForOrg = new Scanner(System.in);
        System.out.println("Введите адрес файла для записи: ");
        String originalFileLocationAddress = " ";
        try {
            originalFileLocationAddress = scannerForOrg.nextLine();
            File file = new File(originalFileLocationAddress).getAbsoluteFile();
            if (!file.exists()) {throw new Exception();}
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес. Попробуйте вновь " + e);
            getOriginalFileLocationAddressС();
        }
        return originalFileLocationAddress;
    }

}
