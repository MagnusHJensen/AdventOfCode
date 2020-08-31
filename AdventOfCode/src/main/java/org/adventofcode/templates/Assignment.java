package org.adventofcode.templates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class Assignment {

    private String name;

    public Assignment (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Node getContent () throws IOException;

    protected Node loadContent (String fxml, Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        loader.setController(controller);
        return loader.load();
    }

    protected Node loadDefaultContent (Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("defaultContent.fxml"));
        loader.setController(controller);
        return loader.load();
    }

    @Override
    public String toString() {
        return name;
    }
}
