import model.Interpolation;
import model.Model;
import utils.Converter;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        double[][] values = new double[20][2];
        double xValue = -1;
        for (int i = 0; i < values.length; i+=1){
            values[i][0] = xValue;
            values[i][1] = Math.sin(4 * xValue);
            xValue+=0.1;
        }

        System.out.println();
        Interpolation interpolation = new Interpolation(values, 0.1);

        /*
        String path = System.getProperty("user.dir")+"\\examples\\"+"model-results-138.json";
        try {
            FileInputStream is = new FileInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder res = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                res.append(line);
            }
            Converter c = new Converter();
            Model m = c.convert(res.toString());
            for (double[] pair : m.getValueAsArray("SUSC")){
               System.out.println("Time:"+pair[0]+" Value:"+pair[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
