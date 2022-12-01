package org.adventofcode;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import org.adventofcode.templates.Calendar;

public class PrimaryController implements Initializable {

    @FXML
    private TabPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            rootPane.getTabs().addAll(
                new Calendar("2022"),
                    new Calendar("2021"),
                    new Calendar("2020"),
                    new Calendar("2018"),
                    new Calendar("2015")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
