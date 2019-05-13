package threading5;

import javafx.scene.control.ProgressBar;

public class ProgressMonitor implements Runnable {
    private ProgressBar progressBar;
    private int operationsToCount;
    private OperationsBuffer buffer;
    private double progress;

    public ProgressMonitor(ProgressBar progressBar, int operationsToCount, OperationsBuffer buffer) {
        this.progressBar = progressBar;
        this.operationsToCount = operationsToCount;
        this.buffer=buffer;
    }
    private void updateProgressBar(){
         progress=((Double.valueOf(this.buffer.getOperationCounter())/Double.valueOf(this.operationsToCount)));
         System.out.println("buffer"+this.buffer.getOperationCounter()+"to count"+this.operationsToCount+"progress"+progress);

         this.progressBar.setProgress(progress);
    }


    @Override
    public void run() {
        while(progress!=1){
            updateProgressBar();
        }
    }
}
