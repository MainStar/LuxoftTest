package test;

import test.Actions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LuxoftTest {

    private File file;
    private List<String> lineList;
    
    public void luxoftTest() throws FileNotFoundException {

        //Read from file
        file = Actions.fileActions().getFile("Test.txt");
        lineList = Actions.fileActions().readFile(file);

        for (String el : lineList){
            Actions.textActions().findMediane(el);
            Actions.textActions().findMaxAndMin(el);
            System.out.println(" ");
            //System.out.println(Actions.textActions().getLongestLetter());
            //System.out.println(Actions.textActions().getShortestLetter());
            //System.out.println(Actions.textActions().getMedianLength(el));
        }

    }
}
