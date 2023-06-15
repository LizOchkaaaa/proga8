package main.org.example.exceptions;

import java.io.File;

public class NoAccessToFileException extends Exception {
    public File file;
    public NoAccessToFileException(File file){
        this.file = file;
    }
}
