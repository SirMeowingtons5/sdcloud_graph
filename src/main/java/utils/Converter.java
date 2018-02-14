package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Column;
import model.Frame;
import model.Model;

/**
 * Class-converter from <b>JSON</b> to <b>Model</b>
 * @author Viacheslav Tarannikov
 * @version 0.1a
 */
public class Converter {

    //TODO: add checks
    /**
     * Method that parses json and creates Model
     * @param jsonText - String that contains JSON
     * @return Model instance
     */
    public Model convert(String jsonText){
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonText).getAsJsonObject();

        Model model = new Model(jsonObject.get("TimeStart").getAsDouble(),
                            jsonObject.get("TimeEnd").getAsDouble());

        jsonObject.get("Columns").getAsJsonArray().forEach(jsonElement -> {
            JsonObject columnObject = jsonElement.getAsJsonObject();
            Column column = new Column(columnObject.get("Id").getAsString(),
                                  columnObject.get("DisplayName").getAsString(),
                                  columnObject.get("UnitName").getAsString());
            model.addColumn(column);
        });

        jsonObject.get("Frames").getAsJsonArray().forEach(jsonElement -> {
            JsonObject frameObject = jsonElement.getAsJsonObject();
            Frame frame = new Frame(frameObject.get("Time").getAsDouble(),
                                    frameObject.get("TimeDelta").getAsDouble());
            JsonObject values = frameObject.get("Values").getAsJsonObject();

            model.getColumns().forEach(column -> {
                if (values.has(column.getId()))
                    frame.addValue(column.getId(),
                            values.get(column.getId()).getAsDouble());

                    });
            model.addFrame(frame);
        });
        return model;
    }
}
