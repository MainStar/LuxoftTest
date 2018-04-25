package test;

import test.Actions.Actions;
import test.Dao.JDBC.DBHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;

public class LuxoftTest {

    private String fileName = "Test.txt";
    private File file;
    private Map<String, String[]> lineStatistic = new HashMap<>();
    private List<String> lineList;
    
    public void luxoftTest() throws FileNotFoundException, SQLException, ClassNotFoundException {

        file = Actions.fileActions().getFile(fileName);
        lineList = Actions.fileActions().readFile(file);

        for (String el : lineList){
            Actions.lineActions().findMediane(el);
            Actions.lineActions().findMaxAndMin(el);
            String[] statisticMass = {Actions.lineActions().getShortestLetter(), Actions.lineActions().getMedianLength(el), Actions.lineActions().getLongestLetter()};
            lineStatistic.put(el, statisticMass);
        }

        DBHelper db = new DBHelper();
        db.connectToDB();
        db.writeFile(fileName);
        db.writeLines(lineStatistic, fileName);

        db.close();

    }
}
