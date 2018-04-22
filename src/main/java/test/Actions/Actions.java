package test.Actions;

public class Actions {

    private static FileActions fileActions;
    private static TextActions textActions;

    public static FileActions fileActions(){
        if (fileActions == null){
            fileActions = new FileActions();
        }
        return fileActions;
    }

    public static TextActions textActions(){
        if (textActions == null){
            textActions = new TextActions();
        }
        return textActions;
    }

}
