package com.javarush.cryptanalyzer.abdeev.repository;



import com.javarush.cryptanalyzer.abdeev.controllers.ProgramMode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public  class FileInput {
    public static Path pathOfOriginalFile;


    public static String getTextForEncryption(){
        return fileToStringConversion(chooseFile());

    }

    public static Path chooseFile(){
        System.out.println("Укажите ссылку на файл:");
        Scanner console = new Scanner(System.in);
        String pathStr = console.nextLine();
        if(!pathStr.equals("")){
        Path pathOfFile = Path.of(pathStr);
         while(!Files.isRegularFile(pathOfFile)){
             System.out.println("Файл по вашей ссылке не найден! Укажите действительный путь к файлу: ");
             pathStr = console.nextLine();
             pathOfFile = Path.of(pathStr);}
         pathOfOriginalFile=pathOfFile;
         return pathOfFile;
        }else{
            if(ProgramMode.mode==1){pathOfOriginalFile=Path.of("input.txt");}
            if(ProgramMode.mode==2 || ProgramMode.mode==3){pathOfOriginalFile=Path.of("encoded.txt");}
             return pathOfOriginalFile;
        }

    }

    public static String fileToStringConversion(Path path){
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения из файла");
        }

    }

}
