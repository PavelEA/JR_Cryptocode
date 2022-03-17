package com.javarush.cryptoanalyser;

import java.util.ArrayList;

public class Encryption {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'',':', '!', '?',' ' };
    static final int smeshenie = ForTheUser.getKey();


    public static ArrayList<Character> setCaesarCipher(ArrayList<Character> textFile, int offset) {
        ArrayList<Character> fileToWrite = new ArrayList<>(textFile);
        for (int i = 0; i < textFile.size(); i++) {
            char a = textFile.get(i);
            for (int j = 0; j < ALPHABET.length ; j++) {
                if(a == ALPHABET[j]){
                    fileToWrite.set(i, ALPHABET[(j + offset) % ALPHABET.length]);
                }
            }

        }
        return fileToWrite;
    }

}

