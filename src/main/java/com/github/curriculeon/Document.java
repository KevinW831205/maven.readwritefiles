package com.github.curriculeon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private final FileWriter fileWriter;
    private final File file;

    public Document(String fileName) throws IOException {
        this(new File(fileName));
    }

    public Document(File file) throws IOException {
        this.file = file;
        this.fileWriter = new FileWriter(file);
    }

    @Override
    public void write(String contentToBeWritten) {
        try {
            fileWriter.write(contentToBeWritten);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Integer lineNumber, String valueToBeWritten) {
        List<String> myList = toList();
        myList.set(lineNumber,valueToBeWritten);
        StringBuilder result = new StringBuilder();
        for(String s : myList){
            result.append(s).append("\n");
        }
        overWrite(result.toString().trim());
    }

    @Override
    public String read(Integer lineNumber) {
        return null;
    }

    @Override
    public String read() {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(new FileReader(file.getAbsolutePath()))) {
            while (scanner.hasNextLine()){
                result.append(scanner.nextLine()+"\n");
            }
            return result.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void replaceAll(String stringToReplace, String replacementString) {
        String result = read();
        result = result.replaceAll(stringToReplace,replacementString);
        overWrite(result);
    }

    @Override
    public void overWrite(String content) {
        try {
            FileWriter overWriter = new FileWriter(file, false);
            overWriter.write(content);
            overWriter.flush();
            overWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<String> toList() {
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(file.getAbsolutePath()))) {
            while (scanner.hasNextLine()){
                result.add(scanner.nextLine());
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
