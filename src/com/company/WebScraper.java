package com.company;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the word you want to search the number of.");
        String wordCheck = input. nextLine();
        String webS = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] wordIns = webS.split(" ");
        int countW = 0;
        System.out.println("Number of words: "+ wordIns.length);
        for (String eachW : wordIns) {
            if (wordCheck.toLowerCase().equals(eachW.toLowerCase())) {
                countW = countW + 1;
            }
        }
        System.out.println("The number of " + wordCheck + " is " + countW);
    }

}
