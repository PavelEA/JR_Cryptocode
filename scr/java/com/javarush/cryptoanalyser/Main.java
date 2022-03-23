package com.javarush.cryptoanalyser;


import com.javarush.cryptoanalyser.brute_force.BruteForce;
import com.javarush.cryptoanalyser.brute_force.KeyVerification;
import com.javarush.cryptoanalyser.file_options.FileOptions;
import com.javarush.cryptoanalyser.for_the_user.ForTheUser;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
       public static void main(String[] args) {
           //FileOptions.readFiles(FileOptions.getCiphertextFileAddress());
           //BruteForce.hackBruteForce(FileOptions.readFiles(FileOptions.getCiphertextFileAddress()));
           FileOptions.writeFiles(BruteForce.hackBruteForce(FileOptions.readFiles(FileOptions.getCiphertextFileAddress())),FileOptions.getCiphertextFileAddress());
            //1. Читаем текст зашифрованного файла - FileOptions.readFiles (String)  == Array<Character> - получаем лист символов с зашифрованным текстом
           // 2. Подбираем перебором все ключи - BruteForce.hackBruteForce (Array<Character>) == Array<Character> - получаем лист всех вариантов правильного текста
           // 3. Пишем в файл - FileOptions.writeFiles(Array<Character> , String ) == void == записали в файл, где можно увидить все варианты
           //BruteForce.readFilesSplitAfter(FileOptions.getCiphertextFileAddress());
           //KeyVerification.getRepresentativeFileAddress();
           //BruteForce.readFilesSplitAfter(KeyVerification.getRepresentativeFileAddress());
           //KeyVerification.findResultBruteForce(BruteForce.readFilesSplitAfter(FileOptions.getCiphertextFileAddress()),BruteForce.readFilesSplitAfter(KeyVerification.getRepresentativeFileAddress()));
           //BruteForce.readFilesSplitAfter(KeyVerification.getResultAddress());
           KeyVerification.writeResult(KeyVerification.findResultBruteForce(BruteForce.readFilesSplitAfter(FileOptions.getCiphertextFileAddress()),BruteForce.readFilesSplitAfter(KeyVerification.getRepresentativeFileAddress())),KeyVerification.getResultAddress());

           // 4.Читаю повторно зафрованный файл с всеми вариантами - BruteForce.readFilesSplitAfter(String) == ArrayList<String> == получаю все варианты в листе стриги
           // 5.Читаю файл с примерным текстом от автора - KeyVerification.getRepresentativeFileAddress() == String == возвращает адрес примера
           // 6. Забиваю элементы в лист стринги - BruteForce.readFilesSplitAfter(String) == ArrayList<String> == получаю слова примеры в листе
           //7. Ищу совпадения - KeyVerification.findResultBruteForce(ArrayList<String>,ArrayList<String>) == ArrayList<String> == возращаю лист с совпадениями
           // 8.Читаю Запрашиваю адресс для резульатат - KeyVerification.getResultAddress() == String == получаю адрес
           //9. Пишу в файл резульат - KeyVerification.writeResult (ArrayList<String> ,String ) - готово














           //ForTheUser.hello(ForTheUser.getWelcomePart(),ForTheUser.getTypesOfCiphers(),ForTheUser.getCHOICE());




       }
}
