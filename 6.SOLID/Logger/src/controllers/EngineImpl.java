package controllers;

import enums.ReportLevel;
import interfaces.Engine;
import interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EngineImpl implements Engine {
    private Logger logger;
    public EngineImpl(Logger logger){
        this.logger = logger;
    }

    @Override
    public void run(String endString, BufferedReader br) throws IOException {
        String input = br.readLine();
        while (!input.equals(endString)){
            String[] tokens = input.split("\\|");
            String time = tokens[1];
            String message = tokens[2];
            this.logger.log(time, message, ReportLevel.valueOf(tokens[0]));
           input = br.readLine();
        }
    }

    @Override
    public String toString() {
        return this.logger.toString();
    }
}
