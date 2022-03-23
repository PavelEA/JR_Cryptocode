package com.javarush.cryptoanalyser.brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KeyVerification {

    public static String getRepresentativeFileAddress() { // читаю файл с примером
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

    public static ArrayList<String> findResultBruteForce(ArrayList<String>a1, ArrayList<String> b1){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < a1.size() ; i++) {
        if (a1.equals(b1)){
            result.add(a1.get(i));
        }}
        return result;
    }
    public static void writeResult(ArrayList<String> textForWrite, String addressForWrite) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(addressForWrite))) {
            for (String c : textForWrite) {
                bufferedWriter.write(c);
            }
        } catch (Exception e) {
            System.out.println("Файл для записи не существует. Попробуйте еще раз");
        }

    }
    public static String getResultAddress() {
        Scanner scannerForRepresent = new Scanner(System.in);
        System.out.println(" Адрес куда выдать результат ");
        String resultAddress = " ";
        try {
            resultAddress = scannerForRepresent.nextLine();
            File file = new File(resultAddress).getAbsoluteFile();
            if (!file.exists()) {throw new Exception();}
        } catch (Exception e) {
            System.out.println("Ошибка ввода. Вы ввели не корректный адрес. Попробуйте вновь " + e);
            getResultAddress();
        }
        return resultAddress;
    }

}
