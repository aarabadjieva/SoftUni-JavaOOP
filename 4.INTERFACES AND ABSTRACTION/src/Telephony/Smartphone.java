package Telephony;

import Telephony.Browsable;
import Telephony.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder allNumbers = new StringBuilder();
        for (String number:this.numbers
        ) {
            String regex = "\\D";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()){
                allNumbers.append("Invalid number!")
                        .append(System.lineSeparator());
            }else {
                allNumbers.append("Calling... " + number)
                        .append(System.lineSeparator());
            }
        }

        return allNumbers.toString();
    }

    @Override
    public String browse() {
        StringBuilder allUrls = new StringBuilder();
        for (String url:this.urls
             ) {
            String regex = "\\d";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()){
                allUrls.append("Invalid URL!")
                        .append(System.lineSeparator());
            }else {
                allUrls.append("Browsing: " + url+"!")
                        .append(System.lineSeparator());
            }
        }
        return allUrls.toString();
    }
}
