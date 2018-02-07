import model.Model;
import utils.Converter;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
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
        }
        //Converter c = new Converter()
    }
}
