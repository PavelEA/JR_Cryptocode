package com.javarush.cryptoanalyser.brute_force;
import java.io.*;
import java.util.ArrayList;

public class BruteForce extends KeyVerification {

    public static void doBruteForceStepOne() {
        writeFiles(hackBruteForce(readFiles(getCiphertextFileAddress())),getCiphertextFileAddressThree());
    }

    public static void doBruteForceStepTwo() {
        writeResult(findResultBruteForce(readFilesSplitAfter(getCiphertextFileAddressTwo()),
                readFilesSplitAfter(getRepresentativeFileAddress())),getResultAddress());
    }// для удобства чтения лучше разнести по локальным переменным (напр. читаем файл, шифруем, записываем)?

    public static ArrayList<Character> hackBruteForce(ArrayList<Character> arrayFromFile) {
        ArrayList<Character> someTextArray = new ArrayList<>();
        for (int key = 1; key < ALPHABET.length; key++) {
            for (Character s : arrayFromFile) {
                char[] chars = Character.toChars(s);
                for (int i = 0; i < chars.length; i++) {
                    char a = chars[i];
                    for (int j = 0; j < ALPHABET.length; j++) {
                        char c = ALPHABET[j];
                        if (c == a) {
                            int bias = (j - key) % ALPHABET.length;
                            if (bias < 0) {
                                bias = bias + ALPHABET.length;
                            }
                            chars[i] = ALPHABET[bias];
                        }
                    }

                }
                for (char newChar : chars) {
                    someTextArray.add(newChar);
                }
            }
            someTextArray.add('\n');
        }
        return someTextArray;
    }


    public static ArrayList<String> readFilesSplitAfter(String text) {
        ArrayList<String> arrayString = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(text))) {
            while (bufferedReader.ready()) {
                String [] arrays = bufferedReader.readLine().split(" ");
                for (int i = 0; i < arrays.length; i++) {
                    arrayString.add(i,arrays[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(getFileNotFoundException());
        }
        return arrayString;
    }
}