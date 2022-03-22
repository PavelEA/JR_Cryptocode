package com.javarush.cryptoanalyser;

import sun.security.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BruteForce {
    public static final char[] ALPHABET = FileOptions.getALPHABET();

    public static void doBruteForce(){
        FileOptions.writeFiles(bruteForceStepOne(readFiles(getRepresentativeFileAddress())), getOriginalFileLocationAddress());
    }


/*1.файл прочитать
            2.пройтись по каждому символу
            3. записать в мапу каждый символ(ключ) + значение(увеличивать от колва  повторений)*/

    public static ArrayList<Character> readFiles(String text){
        return FileOptions.readFiles(text);
    }

    public static ArrayList<Character> bruteForceStepOne(ArrayList<Character> arrayFromFile){
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
                    char a = chars[i];
                    for (int j = 0; j < ALPHABET.length; j++) {// прохожу по алфавиту
                        char c = ALPHABET[j];
                        if (c==a) { // если сиволы равны
                            int bias = (j - key) % ALPHABET.length;
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
            System.out.println(someTextArray);
        }
        return someTextArray;


    }






    public static String getOriginalFileLocationAddress(){
        return FileOptions.getOriginalFileLocationAddress();
    }
    public static String getRepresentativeFileAddress(){
        return FileOptions.getRepresentativeFileAddress();
    }
}
