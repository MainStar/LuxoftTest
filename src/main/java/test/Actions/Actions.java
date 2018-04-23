package test.Actions;

public class Actions {

    private static FileActions fileActions;
    private static LineActions lineActions;

    public static FileActions fileActions(){
        if (fileActions == null){
            fileActions = new FileActions();
        }
        return fileActions;
    }

    public static LineActions lineActions(){
        if (lineActions == null){
            lineActions = new LineActions();
        }
        return lineActions;
    }

}
