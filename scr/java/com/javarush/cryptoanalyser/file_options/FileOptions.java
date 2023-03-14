package com.javarush.cryptoanalyser.file_options;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOptions {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private static final String FILE_NOT_FOUND_EXCEPTION = "Файл указаному адресу не существует или вы ввели не корректный адрес";
    private static final String OUTPUT_FILE_NOT_FOUND = "Файл для записи не существует. Попробуйте еще раз";

    public static String getFileNotFoundException() {
        return FILE_NOT_FOUND_EXCEPTION;
    }

    public static String getOutputFileNotFound() {
        return OUTPUT_FILE_NOT_FOUND;
    }

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
            System.out.println(FILE_NOT_FOUND_EXCEPTION);
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

    public static int getOffset(){
        System.out.println("Введите необходимый для шифра сдвиг: ");
        Scanner scanner = new Scanner(System.in);
        int offset = 0;
        try {
            offset = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не число. Попробуйте вновь ");
            offset = getOffset();
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
            originalFileLocationAddress = getOriginalFileLocationAddress();
        }
        return originalFileLocationAddress;
    }

    public static String getCiphertextFileAddress(){
        Scanner scannerForCip = new Scanner(System.in);
        System.out.println("Введите адрес зашифрованного файла");
        String ciphertextFileAddress = " ";
        try {
            ciphertextFileAddress = scannerForCip.nextLine();
            File file1 = new File(ciphertextFileAddress).getAbsoluteFile();
            if (!file1.exists()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес для записи. Попробуйте вновь" + e);
            ciphertextFileAddress = getCiphertextFileAddress();
        }

        return ciphertextFileAddress;

    }public static String getCiphertextFileAddressTwo(){
        Scanner scannerForCip = new Scanner(System.in);
        System.out.println("Введите адрес с результатами подбора зашифрованного файла");
        String ciphertextFileAddress = " ";
        try {
            ciphertextFileAddress = scannerForCip.nextLine();
            File file1 = new File(ciphertextFileAddress).getAbsoluteFile();
            if (!file1.exists()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес для записи. Попробуйте вновь" + e);
            ciphertextFileAddress = getCiphertextFileAddress();
        }

        return ciphertextFileAddress;
    }
    public static String getCiphertextFileAddressThree(){
        Scanner scannerForCip = new Scanner(System.in);
        System.out.println("Введите адрес для сохранения подобранных вариантов расшифровки");
        String ciphertextFileAddress = " ";
        try {
            ciphertextFileAddress = scannerForCip.nextLine();
            File file1 = new File(ciphertextFileAddress).getAbsoluteFile();
            if (!file1.exists()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес для записи. Попробуйте вновь" + e);
            ciphertextFileAddress = getCiphertextFileAddress();
        }

        return ciphertextFileAddress;
    }

    public static String getRepresentativeFileAddress(){
        Scanner scannerForRepresent = new Scanner(System.in);
        System.out.println("Введите адрес файла с примером текста от автора: ");
        String representativeFileAddress = " ";
        try {
            representativeFileAddress = scannerForRepresent.nextLine();
            File file = new File(representativeFileAddress).getAbsoluteFile();
            if (!file.exists()) {throw new Exception();}
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес. Попробуйте вновь " + e);
            representativeFileAddress = getRepresentativeFileAddress();
        }
        return representativeFileAddress;
    }


}
