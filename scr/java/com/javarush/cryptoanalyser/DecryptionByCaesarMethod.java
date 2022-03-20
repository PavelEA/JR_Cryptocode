package com.javarush.cryptoanalyser;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DecryptionByCaesarMethod {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public static void doDecryption()//зависает на уровене ввода шифра
    {
    FileOptions.writeFiles(setDecryptionCaesar(читаемФайл(),getOffsetС()),getOriginalFileLocationAddressС());


    }
    public static ArrayList<Character> setDecryptionCaesar(ArrayList<Character> textFile, int offset) {
        ArrayList<Character> fileToWrite = new ArrayList<>(textFile);
        for (int i = 0; i < textFile.size(); i++) {
            char a = Character.toLowerCase(textFile.get(i));
            for (int j = ALPHABET.length-1; j > 0; j--) {
                if (a == ALPHABET[j]) {
                    if (j - offset <= 0){
                    j = ALPHABET.length-1- offset;
                        fileToWrite.set(i, ALPHABET[j]);
                }else {
                        fileToWrite.set(i, ALPHABET[j - offset]);
                    }
                }
            }
        }
        return fileToWrite;
    }
    /*public static void writeDecryptionCaesar(ArrayList<Character> fileToWrite, String pathToWrite){
        FileOptions.writeFiles(fileToWrite,pathToWrite);
    }*/

    public static ArrayList<Character> читаемФайл(){
        return FileOptions.readFiles(getCiphertextFileAddressС());
    }


    public static String getCiphertextFileAddressС()//переместить в FileOption!!
    {
        Scanner scannerForCip = new Scanner(System.in);
        System.out.println("Введите адрес зашифрованного файла: ");
        String ciphertextFileAddress = " ";
        try {
            ciphertextFileAddress = scannerForCip.nextLine();
            File file1 = new File(ciphertextFileAddress).getAbsoluteFile();
            if (!file1.exists()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес зашифрованного файла. Попробуйте вновь" + e);
            getCiphertextFileAddressС();
        }

        return ciphertextFileAddress;
    }
    public static int getOffsetС()//переместить в FileOption!!
    {
        System.out.println("Введите необходимый для шифра сдвиг111: ");
        Scanner scanner = new Scanner(System.in);
        int offset = 0;
        try {
            offset = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не число. Попробуйте вновь " + e);
            getOffsetС();
        }
        return offset;
    }
    public static String getOriginalFileLocationAddressС()//переместить в файл опшен!!
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
    public static char[] reverseArray(char[] arr){
        for (int i = 0; i < arr.length/2; i++) {
            char a = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length - i - 1] = a;
        }
        return arr;
    }
}
