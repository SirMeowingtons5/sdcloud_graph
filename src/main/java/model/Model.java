package model;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Class for model instance
 * @author Viacheslav Tarannikov
 * @version 0.1a
 */
public class Model {
    private double timeStart;
    private double timeEnd;
    private ArrayList<Column> columns = new ArrayList<>();
    private ArrayList<Frame> frames = new ArrayList<>();

    /**
     * Constructor
     * @param timeStart - start time of the model
     * @param timeEnd - end time of the model
     */
    public Model(double timeStart, double timeEnd){
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    /**
     * @see Model#timeStart
     * @return Starting time for current model
     */
    public double getTimeStart(){
        return timeStart;
    }

    /**
     * @see  Model#timeEnd
     * @return End time for current model
     */
    public double getTimeEnd(){
        return timeEnd;
    }

    /**
     * Adds column to current model
     * @param column - instance of <b>Column</b>
     */
    public void addColumn(@NotNull Column column){
        columns.add(column);
    }

    /**
     * @return all columns of existing model
     */
    public ArrayList<Column> getColumns() {
        return columns;
    }

    /**
     * Adds frame to current model
     * @param frame - instance of <b>Frame</b>
     */
    public void addFrame(@NotNull Frame frame){
        frames.add(frame);
    }

    /**
     * @return all frames of existing model
     */
    public ArrayList<Frame> getFrames() {
        return frames;
    }


    //TODO: find another name

    /**
     * returns array of pairs [time][value]
     * @param name - variable name
     * @return array of pairs [time][value]
     */
    public double[][] getValueAsArray(String name){
        double[][] res = new double[frames.size()][2];
        for (int i = 0; i < frames.size(); i++){
            res[i][0] = frames.get(i).getTime();
            res[i][1] = frames.get(i).getValue(name);
        }
        return res;
    }
}
