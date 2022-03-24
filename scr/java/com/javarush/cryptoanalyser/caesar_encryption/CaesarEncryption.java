package com.javarush.cryptoanalyser.caesar_encryption;
import com.javarush.cryptoanalyser.file_options.FileOptions;
import java.util.*;

public class CaesarEncryption extends FileOptions {

    public static void doCaesarCipher()
    {
        writeFiles(setCaesarCipher(readFiles(getOriginalFileLocationAddress()),getOffset()),getCiphertextFileAddress());
    }//1. Не получилось реализовать перенос строки. Проверку на символ '\n' не проходил.

    public static ArrayList<Character> setCaesarCipher(ArrayList<Character> textFile, int offset)
    {
        ArrayList<Character> fileToWrite = new ArrayList<>(textFile);
        for (int i = 0; i < textFile.size(); i++) {
            char a = Character.toLowerCase(textFile.get(i));
            for (int j = 0; j < ALPHABET.length; j++) {
                if (a == ALPHABET[j]) {
                    fileToWrite.set(i, ALPHABET[(j + offset) % ALPHABET.length]);
                }
            }
        }
        return fileToWrite;
    }
}

