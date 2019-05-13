package threading5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Controller
{
    @FXML
     TextArea typeArea;
    @FXML
    Button generateChartButton;
    @FXML
    Button stopButton;
    @FXML
    ProgressBar progressBar;
    @FXML
    Label alertPanel;
   // @FXML
   // CategoryAxis categoryAxis;
  //  @FXML
  //  NumberAxis numberAxis;
    @FXML
    BarChart barChart;
    ///////////////////////////
    private ArrayService randomArray;
    private CategoryAxis xAxis= new CategoryAxis();

    OperationsBuffer buffer;

    public void setChart(){

        barChart.setAnimated(false);
        int sizeFromUser;
        alertPanel.setText("");
        try {
            sizeFromUser=UserCommunication.getInstance().getValueFromTextArea(typeArea);
            this.randomArray=new ArrayService(sizeFromUser);
            randomArray.randomDataGenerate();
            addValuesToChart();


        } catch (Exception e) {
            e.printStackTrace();
            this.alertPanel.setText("Wrong value typed.");
        }
    }
    public void startSort(){
        this.buffer=new OperationsBuffer(this.alertPanel);
        ThreadPoolExecutor thread_factory= (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        thread_factory.submit(() ->new BubbleSort(randomArray.getData(),randomArray.getListSize(),buffer).run());
        thread_factory.submit(() ->new ProgressMonitor(this.progressBar,randomArray.getSumOfOperations(),buffer).run());
        thread_factory.shutdown();
    }
    public void pauseOrGo() throws InterruptedException {
        this.buffer.stop();
    }
    private void addValuesToChart() {

            this.barChart.setData(randomArray.getData());
    }

    public void initialize() {

    }
}

