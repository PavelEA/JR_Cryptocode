package com.javarush.cryptoanalyser.brute_force;
import com.javarush.cryptoanalyser.file_options.FileOptions;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KeyVerification extends FileOptions {

    public static String getRepresentativeFileAddress() {
        Scanner scannerForRepresent = new Scanner(System.in);
        System.out.println("Введите адрес файла с примером текста от автора: ");
        String representativeFileAddress = " ";
        try {
            representativeFileAddress = scannerForRepresent.nextLine();
            File file = new File(representativeFileAddress).getAbsoluteFile();
            if (!file.exists()) {throw new Exception();}
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес. Попробуйте вновь " + e);
            getRepresentativeFileAddress();
        }
        return representativeFileAddress;
    }

    public static ArrayList<String> findResultBruteForce(ArrayList<String> cipherList, ArrayList<String> authorsList){
        ArrayList<String> result = new ArrayList<>();
        for (String s : cipherList) {
            for (String value : authorsList) {
                if (s.equalsIgnoreCase(value)) {
                    result.add(s);
                }
            }
        }
        return result;
    }
    public static void writeResult(ArrayList<String> textForWrite, String addressForWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(addressForWrite))) {
            for (String s : textForWrite) {
                bufferedWriter.write(s);
            }
        } catch (Exception e) {
            System.out.println("Файл для записи не существует. Попробуйте еще раз");
        }

    }
    public static String getResultAddress() {
        Scanner scannerForRepresent = new Scanner(System.in);
        System.out.println("Адрес куда выдать результат ");
        String resultAddress = " ";
        try {
            resultAddress = scannerForRepresent.nextLine();
            File file = new File(resultAddress).getAbsoluteFile();
            if (!file.exists()) {throw new Exception();}
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес. Попробуйте вновь ");
            getResultAddress();
        }
        return resultAddress;
    }
}
