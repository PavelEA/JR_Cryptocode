package com.javarush.cryptoanalyser;


import java.util.Scanner;

public class ForTheUser {
    private static final String WELCOME_PART = " Добро пожаловать! Вы можете выбрать один из представленных режимов шифрования:  ";
    private static final String TYPES_OF_CIPHERS = " 1.Шифровка текста по стилю Цезаря \n 2.Расшифровка текста по стилю Цезаря \n 3.Расшифровка текста с помощью brute force \n " +
            "4.Расшифровка с помощью статистического анализа текста \n";
    private static final String CHOICE = "Выберите необходимый режим, нажатием соответствующего числа";
    private static final String EXIT = "\n Для выхода из программы напишите exit";
    private static final String MODE_NOT_FOUND = "Такого режима не существует, введите число от 1 до 4";
    private static final String MODE_ONE = "Вы выбрали режим 1. Шифровка текста по стилю Цезаря. Для этого необходимо ввести адрес оригинального файла, ключ и адрес файла для записи шифра ";
    private static final String MODE_SECOND = " Вы выбрали режим 2.Расшифровка текста по стилю Цезаря. Для этого необходимо ввести сдвиг по алфавиту который использовался при шифровании (ключ)," +
            " адрес куда писать расшифрованный файл и адрес к зашифрованному файлу";
    private static final String MODE_THIRD = " Вы выбрали режим 3жажажаж. Для этого необходимо ввести ключ и путь к файлу";
    private static final String MODE_FOURTH = " Вы выбрали режим 4жажажаж. Для этого необходимо ввести ключ и путь к файлу";
    private static final String SUCCSESS = "Шифрование успешно завершено. Проверьте свой файл.";


    public static String getWelcomePart() {
        return WELCOME_PART;
    }

    public static String getTypesOfCiphers() {
        return TYPES_OF_CIPHERS;
    }

    public static String getCHOICE() { return CHOICE; }

    public static String getEXIT() { return EXIT; }

    public static void hello(String welcomePart, String typesOfCiphers, String choice) {
        System.out.println(welcomePart);
        System.out.println(typesOfCiphers);
        System.out.println(choice);
        System.out.println(EXIT);
        startMainMenu();
    }

    public static void startMainMenu()//нужен выход из программы
    {
        Scanner scanner = new Scanner(System.in);
        try {
            int choiсe = scanner.nextInt();
            switch (choiсe) {
                case 1:
                    System.out.println(MODE_ONE);
                    CaesarEncryption.doCaesarCipher();
                    System.out.println(SUCCSESS);
                    break;
                case 2:
                    System.out.println(MODE_SECOND);
                    //вызов метода для 2 задания
                    System.out.println(SUCCSESS);
                    break;
                case 3:
                    System.out.println(MODE_THIRD);
                    // вызов метода для 3 задания
                    System.out.println(SUCCSESS);
                    break;
                case 4:
                    System.out.println(MODE_FOURTH);
                    // вызов метода для 4 задания
                    System.out.println(SUCCSESS);
                    break;
                default:
                    System.out.println(MODE_NOT_FOUND);
                    startMainMenu();
            }
        } catch (Exception e) {
            System.out.println(MODE_NOT_FOUND);
            startMainMenu();
        }
        scanner.close();
    }
}
