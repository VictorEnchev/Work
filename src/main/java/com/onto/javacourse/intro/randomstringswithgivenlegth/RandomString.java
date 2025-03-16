package com.onto.javacourse.intro.randomstringswithgivenlegth;

/**
 * Contains a method for randomly building a string
 */
public class RandomString {
    /**
     * Creates a random built string with given length out of digits and letters, using Math.random() method
     * @param length the length of the random string
     * @return tha random built string
     */
    public static String getRandomString(int length){
        if(length <= 0) {
            throw new IllegalStateException("Length must be positive");
        }
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = allowedChars.charAt((int) (Math.random() * allowedChars.length()));

            randomString.append(randomChar);
        }

        return randomString.toString();
    }
}
