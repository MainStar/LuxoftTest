package test.Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileActions {

    private List<String> lineList = new ArrayList<String>();

    public File getFile(String path){
        return new File(path);
    }

    public List<String> readFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        while (in.hasNextLine()){
            lineList.add(in.nextLine());
        }
        return lineList;
    }

}
