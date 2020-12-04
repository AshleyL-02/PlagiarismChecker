//Group 29
//Joshua Wang, Ashley Luty, Emma Chen
//The Main class is the primary place to run and test the plagiarism checker

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //EXAMPLE CODE BELOW FOR EXTRA CLARIFICATION
        //
        //demonstrates how to create a converter object two ways
        //  EXAMPLE BELOW: variable c and d represent how to create a converter object with a String
        //  variable e represents how to create a converter object with a file name
        Converter c = new Converter("i love dOGs so, much amazing");
        Converter d = new Converter("I LOVE dogs so much! extraordinary");
        Converter e = new Converter(new Scanner(new File("hello.txt")));

        //demonstrates how to retrieve the Set<String> of n-grams for each document (Converter)
        Set<String> cNGrams = c.getNGrams();
        Set<String> dNGrams = d.getNGrams();

        //demonstrates how to get a similarity score for two documents
        //  EXAMPLE BELOW: in the statement below, we suspect that the document of c has been
        //  plagiarized from the document of d thus, Converter c is written before Converter d
        //  (in the parameters)
        Comparer compareCD = new Comparer(c, d);
        compareCD.compareNGrams();
        System.out.println(cNGrams);
        System.out.println(dNGrams);
        System.out.println(compareCD.getSimilarityScore());
        System.out.println(compareCD.getSynonymScore());

        //TEST HERE
    }
}