package test.Actions;


import java.util.*;

public class LineActions {

    private int min = 0;
    private int max = 0;
    private int totalFrequency = 0;
    private String longestLetter;
    private String shortestLetter;
    private String medianLetter;

    public String getLongestLetter(){
        return longestLetter;
    }

    public String getShortestLetter(){
        return shortestLetter;
    }

    public String getMedianLength(String line){
        return medianLetter;
    }

    public void findMediane(String line){
        int index = 0;
        String[] mass = line.split(" ");

        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < mass.length; i++){
            index += getLetterLength(mass[i]);
            totalFrequency += index;
            map.put(totalFrequency, mass[i]);
        }
        Map<Integer, String> mapSorted = new TreeMap<>(map);

        int g = totalFrequency /2;
        for (Map.Entry<Integer, String> el : mapSorted.entrySet()){
            if (el.getKey() >= g){
                break;
            }else {
                medianLetter = el.getValue();
            }
        }
    }

    public void findMaxAndMin(String line){
        String[] mass = line.split(" ");
        min = 0;
        max = getLetterLength(mass[mass.length / 2]);
        for (String el : mass){
            int i = getLetterLength(el);
            if (i > max ){
                max = i;
                longestLetter = el;
            }else if (min == 0 || i < min){
                min = i;
                shortestLetter = el;
            }
        }
    }

    private int getLetterLength(String letter){
        char[] mass = letter.toCharArray();
        return mass.length;
    }

}
