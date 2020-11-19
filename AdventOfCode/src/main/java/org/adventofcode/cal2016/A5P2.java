package org.adventofcode.cal2016;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.ArrayUtils;
import org.adventofcode.utils.StringUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@CalenderAssignment(calendarName = "2016", assignmentName = "Door code cracker: random order", number = 10, description = "Find the code of the door using MD5 hashing!")
public class A5P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A5P2(String name) {
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
        String[] code = new String[8];

        while (!allFound(code)) {
            if (index % 100000 == 0) System.out.println(index);

            String hex = hash(doorId + index);

            if (hex.startsWith("00000")) {
                try {
                    int position = Integer.parseInt(hex.substring(5, 6));

                    if (position < 8 && code[position] == null) {
                        System.out.println("FOUND");
                        code[position] = hex.substring(6, 7);
                    }
                }
                catch (Exception e) {

                }
            }

            index++;
        }

        output.setText("Code: " + Arrays.toString(code));
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

    private boolean allFound (String[] code) {
        for (String st : code) {
            if (st == null) return false;
        }

        return true;
    }
}
