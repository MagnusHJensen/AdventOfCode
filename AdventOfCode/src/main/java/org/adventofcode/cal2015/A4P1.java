package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.math.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = "2015", assignmentName = "Mining AdventCoins", number = 7, description = "Get secret key\nFind lowest number appended to key, which results in a md5 hash starting with 5 zeros")
public class A4P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A4P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String key = input.getText();
        int num = 0;
        String result = "ttttt";

        while (!result.substring(0, 5).equals("00000")) {
            num++;
            String hash = key + num;
            md5.update(hash.getBytes());
            result = bytesToHex(md5.digest());

        }

        output.setText("Full hash: " + key + num + "\nResult: " + result);
    }

    private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes();
    public static String bytesToHex(byte[] bytes) {
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }
}
