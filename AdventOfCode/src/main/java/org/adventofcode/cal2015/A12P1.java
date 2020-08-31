package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

@CalenderAssignment(calendarName = "2015", assignmentName = "Accounting sum", number = 23, description = "Get JSON string\n What is the sum of all the numbers in the string?")
public class A12P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A12P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {
        String json = input.getText();

        JSONParser parser = new JSONParser();
        int total = 0;

        try {
            JSONArray root = (JSONArray)parser.parse(json);
            total = sumInArray(root);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        output.setText("Total in accounting: " + total);
    }

    private int sumInArray (JSONArray array) {
        int total = 0;

        for (int i = 0; i < array.size(); i++) {
            Object obj = array.get(i);

            if (obj instanceof Integer) {
                total += 0;
            }
            else if (obj instanceof JSONArray) {
                total += sumInArray((JSONArray) obj);
            }
            else if (obj instanceof JSONObject) {
                total += sumInObject((JSONObject)obj);
            }
        }

        return total;
    }

    private int sumInObject (JSONObject object) {
        int total = 0;

        for (Object key : object.keySet()) {
            Object obj = object.get(key);

            if (obj instanceof Integer) {
                total += 0;
            }
            else if (obj instanceof JSONArray) {
                total += sumInArray((JSONArray) obj);
            }
            else if (obj instanceof JSONObject) {
                total += sumInObject((JSONObject)obj);
            }
        }

        return total;
    }
}
