package com.javarush.cryptoanalyser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String abc = "./scr/java/com/javarush/cryptoanalyser/input.txt";
        String fileName = scanner.nextLine();
        /*try (RandomAccessFile randomAccessFile = new RandomAccessFile("./scr/java/com/javarush/cryptoanalyser/input.txt", "rw");
             FileChannel fileChannel = randomAccessFile.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(100);

            StringBuilder stringBuilder = new StringBuilder();
            fileChannel.read(byteBuffer);

            while (byteBuffer.hasRemaining()) {
                stringBuilder.append((char) byteBuffer.get());
            }
            System.out.println("Здесь будет текст из файла: ");
            String sometext = "ты это, заходи если че";
            System.out.println(stringBuilder + sometext);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
       /* try (BufferedWriter bufferedWritter = new BufferedWriter(new FileWriter("file.txt"));
             BufferedReader bufferedReader = new BufferedReader(new FileReader("./scr/java/com/javarush/cryptoanalyser/input.txt"))) {
            while (bufferedReader.ready()) {
                char line = (char) bufferedReader.read();
                System.out.println(line);
                System.out.println("-----------------------");


            }


        } catch (IOException e) {
            e.printStackTrace();
        }*/

        System.out.println(ReadFiles(abc));
        chezar(ReadFiles(abc));


    }


    public static char chezar(ArrayList<String> textFile) {
        final int smeshenie = 2;
        for (int i = 0; i < ALPHABET.length; i++) {
            char abc = ALPHABET[i];
            if (valueOf(abc).equals(valueOf(textFile))) {
                ALPHABET[i] = ALPHABET[i + smeshenie];
            }
        }
        return 0;
    }


    public static ArrayList<String> ReadFiles(String file) {
        ArrayList<String> textFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                textFile.add(bufferedReader.readLine());
            }
            return textFile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textFile;
    }
}
