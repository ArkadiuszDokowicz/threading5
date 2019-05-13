package threading5;

import javafx.scene.control.Label;

import java.util.concurrent.Semaphore;

public class OperationsBuffer {


    private volatile boolean ability=true;
    private volatile int operationsSolved=0;
    private Label alertLabel;

    public OperationsBuffer(Label alertLabel) {
        this.alertLabel=alertLabel;
    }

    public synchronized int getOperationCounter() {
        return this.operationsSolved;
    }


    public synchronized void operationSolved(){
        this.operationsSolved++;
        System.out.println(this.operationsSolved);
    }
    public synchronized void stop(){
        if(ability){
            this.ability=false;
            this.alertLabel.setText("Algorithm has been stopped");
        }
        else{
            this.ability=true;
            this.alertLabel.setText("");
        }
    }

    public boolean isAbility() {
        return ability;
    }
}
