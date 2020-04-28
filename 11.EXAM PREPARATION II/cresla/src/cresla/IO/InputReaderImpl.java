package cresla.IO;

import cresla.interfaces.InputReader;

import java.util.Scanner;

public class InputReaderImpl implements InputReader {
    Scanner scanner;

    public InputReaderImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return this.scanner.nextLine();
    }
}
