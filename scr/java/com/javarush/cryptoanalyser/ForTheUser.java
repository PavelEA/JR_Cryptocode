package com.javarush.cryptoanalyser;


import java.util.Scanner;

public class ForTheUser {
    private static final String WELCOME_PART = " Добро пожаловать! Вы можете выбрать один из представленных режимов шифрования:  ";
    private static final String TYPES_OF_CIPHERS = " 1. Шифровка текста по стилю Цезаря \n 2.Расшифровка текста по стилю Цезаря \n 3.Расшифровка текста с помощью brute force \n " +
            "4. Расшифровка с помощью статистического анализа текста \n";
    private static final String CHOICE = "Выберите необходимый режим, нажатием соответствующего числа";

    public static String getWelcomePart() {
        return WELCOME_PART;
    }

    public static String getTypesOfCiphers() {
        return TYPES_OF_CIPHERS;
    }

    public static String getCHOICE() {
        return CHOICE;
    }

    public static void hello(String welcomePart, String typesOfCiphers, String choice) {
        System.out.println(welcomePart);
        System.out.println(typesOfCiphers);

        System.out.println(choice);
        afafaf();
    }

    public static void afafaf() {
        Scanner scanner = new Scanner(System.in);
        int choiсe = scanner.nextInt();

        switch (choiсe) {

            case 1:
                System.out.println(" Вы выбрали режим 1. Шифровка текста по стилю Цезаря. Для этого необходимо ввести ключ и адрес файла");
                CaesarEncryption.dataCollection();
                break;
            case 2:
                System.out.println(" Вы выбрали режим 2. Расшифровка текста по стилю Цезаря. Для этого необходимо ввести сдвиг по алфавиту который использовался при шифровании (ключ)," +
                        " адрес куда писать расшифрованный файл и адрес к зашифрованному файлу");
                //вызов метода для 2 задания
                break;
            case 3:
                System.out.println(" Вы выбрали режим 3жажажаж. Для этого необходимо ввести ключ и путь к файлу");
                break;
            case 4:
                System.out.println(" Вы выбрали режим 4жажажаж. Для этого необходимо ввести ключ и путь к файлу");
                break;
            default:
                System.out.println("Такого режима не существует, введите число от 1 до 4");
                afafaf();
        }
        scanner.close();
    }







    /*public static Scanner getScanner() { // какие могут быть ошибки при вызове сканера?
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner;
        }

    }*/

    public void choiceOfCaesarCiphers() {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        int offset = scanner.nextInt();
    }


    public static int getKey() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
