package com.github.curriculeon;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class AlphaCharDocument extends Document {
    public AlphaCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if (isAlpha(contentToBeWritten)) {
            super.write(contentToBeWritten);
            return;
        }
        throw new IllegalArgumentException(contentToBeWritten);
    }

    private Boolean isAlpha(String s) {
        String regex  = "^[a-zA-Z\\s]*$";
        System.out.println(s +s.matches(regex));
        return s.matches(regex);
    }
}
