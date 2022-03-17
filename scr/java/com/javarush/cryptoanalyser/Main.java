package com.javarush.cryptoanalyser;



public class Main {
       public static void main(String[] args) {
           ForTheUser.hello(ForTheUser.getWelcomePart(),ForTheUser.getTypesOfCiphers());
        Encryption.setCaesarCipher(FileOptions.readFiles(ForTheUser.getFilePath()),Encryption.smeshenie);
       }










}
