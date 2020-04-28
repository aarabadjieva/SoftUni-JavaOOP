package models;

import interfaces.File;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Stream;

public class LogFile implements File {
    private static final String DEFAULT_PATH_AND_NAME = "output.txt";
    private StringBuilder text;
    private int size;
    private String filePathAndName;

    public LogFile() {
        this.text = new StringBuilder();
        this.size = 0;
        this.filePathAndName = LogFile.DEFAULT_PATH_AND_NAME;
    }

    public LogFile(String filePathAndName){
        this();
        this.filePathAndName = filePathAndName;
    }

    @Override
    public boolean write() {
        try{
            Files.write(Paths.get(this.filePathAndName),
                    this.text.append(System.lineSeparator()).toString().getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private int calculateSize(){
       int size = 0;
        for (char c:this.text.toString().toCharArray()
             ) {
            if (Character.isAlphabetic(c)){
                size+=c;
            }
        }
        return size;
    }
    @Override
    public int getSize() {
        return this.calculateSize();
    }

    @Override
    public void append(String text) {
        this.text.append(text);
    }
}
