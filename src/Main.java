//Group 29
//Joshua Wang, Ashley Luty, Emma Chen
//The Main class is the primary place to run and test the plagiarism checker

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //set up the synonym map before use IMPORTANT DO NOT DELETE!!!!
        SynonymMap.setupMap(); //-> DO NOT DELETE THIS

        //EXAMPLE CODE BELOW FOR EXTRA CLARIFICATION
        //
        //demonstrates how to create a converter object two ways
        //  EXAMPLE BELOW: variable c and d represent how to create a converter object with a String
        //  variable e represents how to create a converter object with a file name
        Converter c = new Converter("i love dOGs so, much amazing");
        Converter d = new Converter("I LOVE dogs so much! extraordinary");
        //Converter e = new Converter(new Scanner(new File("hello.txt")));

        //demonstrates how to retrieve the Set<String> of n-grams for each document (Converter)
        Set<String> cNGrams = c.getNGrams();
        Set<String> dNGrams = d.getNGrams();
        System.out.println(cNGrams);
        System.out.println(dNGrams);

        //demonstrates how to get a similarity score for two documents
        //  EXAMPLE BELOW: in the statement below, we suspect that the document of c has been
        //  plagiarized from the document of d thus, Converter c is written before Converter d
        //  (in the parameters)
        Comparer compareCD = new Comparer(c, d);
        System.out.println("The exact similarity score of document c and document d is " +
                            compareCD.getExactScore() + "%");
        System.out.println(compareCD.getSynonymExactScoreMessage());

        //TEST HERE
    }
}
