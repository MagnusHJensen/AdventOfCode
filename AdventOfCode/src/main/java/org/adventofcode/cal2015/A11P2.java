package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.StringUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@CalenderAssignment(calendarName = "2015", assignmentName = "Santa's password: Again", number = 22, description = "Get santa's last password\nSanta's new password is the first password which meets the requirements, when incrementing the old password\nWhat is the new password, after two times?")
public class A11P2 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A11P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {
        String curPassword = input.getText();

        while (!(StringUtils.containsIncreasingStraight(curPassword, 3) && !containIOL(curPassword) && containsDifferntNonOverlappingPair(curPassword))) {
            curPassword = incrementPassword(curPassword, curPassword.length()-1);
        }

        curPassword = incrementPassword(curPassword, curPassword.length()-1);

        while (!(StringUtils.containsIncreasingStraight(curPassword, 3) && !containIOL(curPassword) && containsDifferntNonOverlappingPair(curPassword))) {
            curPassword = incrementPassword(curPassword, curPassword.length()-1);
        }

        output.setText("Santa's next password: " + curPassword);
    }

    private String incrementPassword (String password, int index) {
        if (index < 0) {
            return password;
        }

        char next = (char)(password.charAt(index) + 1);

        String newPass = password.substring(0, index) + next + password.substring(index+1);

        if (next > 'z') {
            next = 'a';
            newPass = password.substring(0, index) + next + password.substring(index+1);
            return incrementPassword(newPass, index-1);
        }


        return newPass;
    }

    private boolean containIOL (String password) {
        return password.contains("i") || password.contains("o") || password.contains("l");
    }

    private boolean containsDifferntNonOverlappingPair (String password) {
        if (StringUtils.hasDoubleLetter(password, 0)) {
            char letter = 'a';
            int count = 0;

            for (int i = 0; i < 26; i++) {
                if (password.contains(letter + "" + letter)) {
                    count++;
                }
                letter++;
            }

            return count >= 2;
        }
        return false;
    }
}
