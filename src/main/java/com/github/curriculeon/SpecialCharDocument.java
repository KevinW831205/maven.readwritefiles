package com.github.curriculeon;

import java.io.IOException;

/**
 * @author leon on 18/11/2018.
 */
public class SpecialCharDocument extends Document {
    public SpecialCharDocument(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String contentToBeWritten) {
        if (isSpecialCharacters(contentToBeWritten)) {
            super.write(contentToBeWritten);
            return;
        }
        throw new IllegalArgumentException(contentToBeWritten);
    }

    private Boolean isSpecialCharacters(String s) {
        String regex = "^[!@#$%^&*(),.?\":;'{}|<>_+=\\\\\\-]*$";
        return s.matches(regex);
    }
}
