package threading5;

import javafx.scene.control.TextArea;

public class UserCommunication {
    private static UserCommunication ourInstance = new UserCommunication();

    public static UserCommunication getInstance() {
        return ourInstance;
    }

    public int getValueFromTextArea(TextArea typeArea)throws Exception{
        int sizeFromUser=Integer.valueOf(typeArea.getText());
        if(sizeFromUser>0){
        return sizeFromUser;
        }
        else{
            throw new Exception();
        }
    }

    private UserCommunication() {
    }
}
