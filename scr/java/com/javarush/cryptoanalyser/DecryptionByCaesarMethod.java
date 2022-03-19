package com.javarush.cryptoanalyser;

import java.util.ArrayList;

public class DecryptionByCaesarMethod {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public static void doDecryption(){
    writeDecryptionCaesar(setDecryptionCaesar(FileOptions.readFiles(CaesarEncryption.getCiphertextFileAddress()),CaesarEncryption.getOffset()),CaesarEncryption.getOriginalFileLocationAddress());


    }
    public static ArrayList<Character> setDecryptionCaesar(ArrayList<Character> textFile, int offset) {
        ArrayList<Character> fileToWrite = new ArrayList<>(textFile);
        for (int i = 0; i < textFile.size(); i++) {
            char a = Character.toLowerCase(textFile.get(i));
            for (int j = 0; j < ALPHABET.length; j++) {
                if (a == ALPHABET[j]) {
                    fileToWrite.set(i, ALPHABET[(j - offset) % ALPHABET.length]);
                }
            }
        }
        return fileToWrite;
    }
    public static void writeDecryptionCaesar(ArrayList<Character> fileToWrite, String pathToWrite){
        FileOptions.writeFiles(fileToWrite,pathToWrite);
    }



}
