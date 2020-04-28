package controllers;

import java.io.BufferedReader;
import java.io.IOException;

public class InputParser {

    public String readLoggerInfo(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0){
            sb.append(br.readLine()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
