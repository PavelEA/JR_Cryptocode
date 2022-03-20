package com.javarush.cryptoanalyser;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
       public static void main(String[] args) {
          ForTheUser.hello(ForTheUser.getWelcomePart(),ForTheUser.getTypesOfCiphers(),ForTheUser.getCHOICE());
       }
}
