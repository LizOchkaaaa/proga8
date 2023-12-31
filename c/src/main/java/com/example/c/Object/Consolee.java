package com.example.c.Object;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Consolee {
    private static Consolee instance;
    private Scanner scanner;
    private BufferedReader bufferedReader;
    private boolean exeStatus;

    public static Consolee getInstance() {
        if (instance == null) instance = new Consolee();
        return instance;
    }


    public void setScanner(Scanner aScanner) {
        exeStatus = false;
        scanner = aScanner;
    }


    public void print(Object anObj) {
        System.out.print(anObj);
    }


    public void print(Object anObj, boolean fieldsReading) {
        if (!exeStatus || !fieldsReading) print(anObj);
    }


    public String read() throws IOException {

        try {
            return (!exeStatus) ? scanner.nextLine().trim() : bufferedReader.readLine();
        } catch (NoSuchElementException exception) {
            System.exit(0);
            return null;
        }
    }


    public boolean getExeStatus() {
        return exeStatus;
    }

    public void setBufferedReader(BufferedReader aBufferedReader) {
        bufferedReader = aBufferedReader;
    }

    public void setExeStatus(boolean anExeStatus) {
        exeStatus = anExeStatus;
    }
}
