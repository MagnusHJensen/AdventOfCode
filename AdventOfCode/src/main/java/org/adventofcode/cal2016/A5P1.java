package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = "2016", assignmentName = "Door code cracker", number = 9, description = "Find the code of the door using MD5 hashing!")
public class A5P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A5P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }


    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String doorId = input.getText();
        int index = 0;
        String code = "";

        while (code.length() < 8) {
            if (index % 100000 == 0) System.out.println(index);

            String hex = hash(doorId + index);

            if (hex.startsWith("00000")) {
                System.out.println("FOUND");
                code += hex.substring(5,6);
            }

            index++;
        }

        output.setText("Code: " + code);
    }

    private String hash (String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());
        byte[] digest = md.digest();
        String myHash = "";
        for (byte b : digest) {
            myHash += String.format("%02X", b);
        }

        return myHash;
    }
}
