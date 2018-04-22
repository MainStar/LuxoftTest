package test.Actions;


import java.util.*;

public class TextActions {

    private int min = 0;
    private int max = 0;
    private int median = 0;
    private int[][] letersLength;
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
        int totalFreeq = 0;
        int index = 0;
        String[] mass = line.split(" ");
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> notSorted = new ArrayList<Integer>();
        for (int i = 0; i < mass.length; i++){
            int z = getLetterLength(mass[i]);
            totalFreeq += z;
            list.add(z);
            notSorted.add(totalFreeq);
        }
        Collections.sort(list);
        int mid = totalFreeq / 2;
        findMaxAndMin(line);
        medianLetter = mass[list.size()/4*3-1];
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < mass.length; i++){
            map.put(getLetterLength(mass[i]), mass[i]);
        }
        Map<Integer, String> mapSorted = new TreeMap<>(map);
        for (Map.Entry<Integer, String> el : mapSorted.entrySet()){
            int z =+ el.getKey() ;
            if (z > totalFreeq / 2){
                break;
            }else {
                
            }
        }
        for (Map.Entry<Integer, String> el : mapSorted.entrySet()){
            System.out.println(el.getKey() + " " + el.getValue());
            /*if (z > totalFreeq/2) {
                medianLetter = el.getValue();
                System.out.println(medianLetter);
            }*/
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
