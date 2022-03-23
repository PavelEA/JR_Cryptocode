package com.javarush.cryptoanalyser.for_the_user;
import com.javarush.cryptoanalyser.caesar_encryption.CaesarEncryption;
import com.javarush.cryptoanalyser.decryption_by_caesar_method.DecryptionByCaesarMethod;
import com.javarush.cryptoanalyser.brute_force.BruteForce;

import java.util.Scanner;

public class ForTheUser {

    private static final String WELCOME_PART = " Добро пожаловать! Вы можете выбрать один из представленных режимов шифрования:  ";
    private static final String TYPES_OF_CIPHERS = " 1.Шифровка текста по стилю Цезаря \n 2.Расшифровка текста по стилю Цезаря \n 3.Расшифровка текста с помощью brute force \n " +
            "4.Расшифровка с помощью статистического анализа текста \n";
    private static final String CHOICE = "Выберите необходимый режим, нажатием соответствующего числа";
    private static final String EXIT = "\nДля выхода из программы нажмите 0";
    private static final String MODE_EXIT = "\nВы вышли из приложения. До свидания";
    private static final String MODE_NOT_FOUND = "Такого режима не существует, введите число от 1 до 4, для выхода 0";
    private static final String MODE_ONE = "Вы выбрали режим 1. Шифровка текста по стилю Цезаря. Для этого необходимо ввести адрес оригинального файла, ключ и адрес файла для записи шифра ";
    private static final String MODE_SECOND = "Вы выбрали режим 2. Расшифровка текста по стилю Цезаря. Для этого необходимо ввести адрес зашифрованного файла, ключ и адрес файла для записи расшифрованного текста ";
    private static final String MODE_THIRD = "Вы выбрали режим 3. Расшифровка Brute Force. Для этого необходимо ввести адрес зашифрованного файла и адрес файла для записи расшифрованного текста";
    private static final String MODE_FOURTH = "Вы выбрали режим 4. Статистический анализ . Эта версия находится на стадии разработки и временно недоступна. Пожалуйста воспользуйтесь другими режимами";
    private static final String SUCCESS = "Шифрование успешно завершено. Проверьте свой файл.";


    public static String getWelcomePart() {
        return WELCOME_PART;
    }

    public static String getTypesOfCiphers() {
        return TYPES_OF_CIPHERS;
    }

    public static String getCHOICE() { return CHOICE; }

    public static String getEXIT() { return EXIT; }

    public static void hello(String welcomePart, String typesOfCiphers, String choice) {
        System.out.println(WELCOME_PART);
        System.out.println(getTypesOfCiphers());
        System.out.println(choice);
        System.out.println(EXIT);
        startMainMenu();
    }

    public static void startMainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        try {
            int choiсe = scanner.nextInt();
            switch (choiсe) {
                case 1:
                    System.out.println(MODE_ONE);
                    CaesarEncryption.doCaesarCipher();
                    System.out.println(SUCCESS);
                    break;
                case 2:
                    System.out.println(MODE_SECOND);
                    DecryptionByCaesarMethod.doDecryption();
                    System.out.println(SUCCESS);
                    break;
                case 3:
                    System.out.println(MODE_THIRD);
                    BruteForce.doBruteForceStepOne();
                    BruteForce.doBruteForceStepTwo();
                    System.out.println(SUCCESS);
                    break;
                case 4:
                    System.out.println(MODE_FOURTH + "\n");
                    System.out.println(CHOICE);
                    startMainMenu();
                    break;
                case 0:
                    System.out.println(MODE_EXIT);
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
