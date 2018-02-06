import com.sun.istack.internal.NotNull;
import java.util.HashMap;

/**
 * Wrapper class for each frame with <b>Time</b>, <b>TimeDelta</b> and <b>Values</b> fields
 * @author Viacheslav Tarannikov
 * @version 0.1a
 */
public class Frame {
    private double time;
    private double timeDelta;

    /** Field for storing values of current frame*/
    private HashMap<String, Double> values = new HashMap<>();

    /**
     * Constructor
     * @param time - absolute time from starting model
     * @param timeDelta - time difference between current and previous frames
     */
    public Frame(double time, double timeDelta){
        this.time = time;
        this.timeDelta = timeDelta;
    }

    /**
     * Adds value to current frame
     * @see Frame#values
     * @param key - column ID
     * @param value - column value
     */
    void addValue(@NotNull String key, double value){
        values.put(key, value);
    }


    /**
     * Function returns frame time
     * @see Frame#time
     * @return current frame time
     */
    double getTime(){
        return time;
    }

    /**
     * Function returns time difference between previous and current frames
     * @see Frame#timeDelta
     * @return time delta between previous and current frame
     */
    double getTimeDelta(){
        return timeDelta;
    }

    /**
     * Function returns column's value
     * @see Frame#values
     * @param key - column ID
     * @return column's value at current frame
     */
    double getValue(@NotNull String key){
        return values.get(key);
    }
}
