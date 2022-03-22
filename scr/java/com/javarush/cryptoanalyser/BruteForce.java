package com.javarush.cryptoanalyser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BruteForce {
    public static final char[] ALPHABET = FileOptions.getALPHABET();

    public static void doBruteForce(){
       bruteForceStepOne(readFiles(getRepresentativeFileAddress()));
    }


/*1.файл прочитать
            2.пройтись по каждому символу
            3. записать в мапу каждый символ(ключ) + значение(увеличивать от колва  повторений)*/

    public static ArrayList<Character> readFiles(String text){
        return FileOptions.readFiles(text);
    }

    public static void bruteForceStepOne(ArrayList<Character> arrayFromFile){
        /*HashMap<Character,Integer> mapForWrite = new HashMap<>();
        for (Character character : arrayFromFile) {
            char a = Character.toLowerCase(character);
            int value = 1;
            mapForWrite.put(a, value);
            for (Character b:mapForWrite.keySet()) {
                if (b==a) {
                    System.out.println(mapForWrite.keySet());
                    value+=1;
                    mapForWrite.put(a, value);
                }
            }


           System.out.println(mapForWrite);}*/
        ArrayList<Character> someTextArray = new ArrayList<>();
        for (int key = 1; key < ALPHABET.length ; key++) { // беру ключ(сдвиг),
            for (Character s : arrayFromFile){//с этим ключом прохожу по всему листу
                char[] chars = Character.toChars(s);//записываю значения листа в массив ====(массив с оригинал текстом)
                for (int i = 0; i < chars.length; i++) {//прохожу по массиву
                    for (char c : ALPHABET) {// прохожу по алфавиту
                        if (chars[i] == c) { // если индекс буквы из массива символов = индексу букве алфавита
                            int bias = ((int) c - key) % ALPHABET.length;
                            if (bias < 0) {
                                bias = bias + ALPHABET.length;
                                chars[i] = ALPHABET[bias];

                            }
                        }
                    }


                }
                for (char newChar : chars) { // в лист записали один из вариантов текста со смещением key
                    someTextArray.add(newChar);
                }



            }
        someTextArray.add((char)Integer.parseInt("\n"));} // после каждого варианта сделали перенос строки

    }






    public static String getOriginalFileLocationAddress(){
        return FileOptions.getOriginalFileLocationAddress();
    }
    public static String getRepresentativeFileAddress(){
        return FileOptions.getRepresentativeFileAddress();
    }
}
