package threading5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayService {
    private ObservableList<XYChart.Series<String, Integer>> data = FXCollections.observableArrayList();
    private int listSize;

    public ArrayService(int listSize) {
        this.listSize = listSize;


    }

    protected void randomDataGenerate(){
        data.clear();
        XYChart.Series<String, Integer> aSeries = new XYChart.Series<String, Integer>();
        aSeries.setName("Numbers");
        for(int i=0;i<listSize;i++){
            aSeries.getData().add(new XYChart.Data(Integer.toString(i),new Random().nextInt(20)));

        }
        data.add(aSeries);
    }
    private void emptyDataGenerate(){
        data.clear();
        XYChart.Series<String, Integer> aSeries = new XYChart.Series<String, Integer>();
        aSeries.setName("Numbers");
        for(int i=0;i<listSize;i++){
            aSeries.getData().add(new XYChart.Data(Integer.toString(i),0));

        }
        data.add(aSeries);
    }

    public ObservableList<XYChart.Series<String, Integer>> getData() {
        return data;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public int getSumOfOperations(){
        int sum=0;
        for (int i = 0; i < (this.listSize)-1; i++){
            for (int j = 0; j < (this.listSize)-i-1; j++){
                sum++;
            }}
        return sum;
    }

}
