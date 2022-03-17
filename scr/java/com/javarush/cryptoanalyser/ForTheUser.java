package com.javarush.cryptoanalyser;


import java.util.Scanner;

public class ForTheUser {
    private static final String WELCOME_PART = " Добро пожаловать! Вы можете выбрать один из представленных режимов шифрования:  ";
    private static final String TYPES_OF_CIPHERS = " 1. Шифр Цезаря /n 2.Бла бла /n 3.Бла блаб /n 4.Бла бла /n Выберите необходимый режим, нажатием соответствующего числа";
    public static String getWelcomePart() {
        return WELCOME_PART;
    }
    public static String getTypesOfCiphers() {
        return TYPES_OF_CIPHERS;
    }

    public static void hello(String welcomePart,String typesOfCiphers){
        System.out.println(welcomePart);
        System.out.println(typesOfCiphers);

        Scanner scanner = new Scanner(System.in);
        int choiсe = scanner.nextInt();
        switch (choiсe){
            case 1 -> System.out.println(" Вы выбрали режим 1жажажаж. Для этого необходимо ввести ключ и путь к файлу");
            case 2 -> System.out.println(" Вы выбрали режим 2жажажаж. Для этого необходимо ввести ключ и путь к файлу");
            case 3 -> System.out.println(" Вы выбрали режим 3жажажаж. Для этого необходимо ввести ключ и путь к файлу");
            case 4 -> System.out.println(" Вы выбрали режим 4жажажаж. Для этого необходимо ввести ключ и путь к файлу");
            default -> System.out.println("Такого режима не существует, введите число от 1 до 4");

        }


    }
    public void choiceOfCaesarCiphers(){
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        int offset = scanner.nextInt();
    }












    public static int getKey(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static String getFilePath(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
