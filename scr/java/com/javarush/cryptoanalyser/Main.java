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
           KeyVerification.writeResult(KeyVerification.findResultBruteForce(BruteForce.readFilesSplitAfter(BruteForce.writeFile1s(BruteForce.hackBruteForce(FileOptions.readFiles(FileOptions.getOriginalFileLocationAddress())),FileOptions.getOriginalFileLocationAddress())),BruteForce.readFilesSplitAfter(KeyVerification.getRepresentativeFileAddress())),KeyVerification.getResultAddress());




           //ForTheUser.hello(ForTheUser.getWelcomePart(),ForTheUser.getTypesOfCiphers(),ForTheUser.getCHOICE());




       }
}
