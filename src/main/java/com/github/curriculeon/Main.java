package com.github.curriculeon;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "target\\file.txt";
        try {
            Document doc = new Document(fileName);
            doc.write("abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
