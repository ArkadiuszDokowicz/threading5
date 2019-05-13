package threading5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public class BubbleSort implements Runnable {

    private ObservableList<XYChart.Series<String, Integer>> data = FXCollections.observableArrayList();
    private int listSize;
    private OperationsBuffer buffer;

    public BubbleSort(ObservableList<XYChart.Series<String, Integer>> data, int listSize,OperationsBuffer buffer) {
        this.data = data;
        this.listSize = listSize;
        this.buffer=buffer;
    }

    public void bubbleSort() throws InterruptedException {
        for (int i = 0; i < (this.listSize)-1; i++){
            for (int j = 0; j < (this.listSize)-i-1; j++){

                    Thread.sleep(500);
                    this.buffer.operationSolved();
                    if ((data.get(0).getData().get(j).getYValue()).intValue() >(data.get(0).getData().get(j+1).getYValue()).intValue())
                    {
                        // swap arr[j+1] and arr[i]
                        Integer temp=data.get(0).getData().get(j).getYValue();
                        data.get(0).getData().get(j).setYValue(data.get(0).getData().get(j+1).getYValue());
                        //arr[j] = arr[j+1];
                        data.get(0).getData().get(j+1).setYValue(temp);
                        //arr[j+1] = temp;
                    }
                if(buffer.isAbility()){

                }
                else{
                    while(true){
                        if(buffer.isAbility()){
                            break;
                        }
                    }
                }

            }
        }
    }


    @Override
    public void run() {
        try {
            bubbleSort();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
