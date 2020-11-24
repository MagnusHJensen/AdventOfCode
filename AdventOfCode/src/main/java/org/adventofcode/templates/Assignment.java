package org.adventofcode.templates;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.App;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

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

    protected Node loadDefaultContent (Assignment controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("defaultContent.fxml"));
        loader.setController(controller);
        return loader.load();
    }

    protected void setInputContent(TextArea input, int assignmentNumber) throws IOException {
        Path inputPath = Path.of("./input", assignmentNumber + ".txt");
        if (inputPath.toFile().exists()) {
            Scanner scanner = new Scanner(Path.of("./input", assignmentNumber + ".txt"));
            while (scanner.hasNextLine()) {
                input.appendText(scanner.nextLine() + "\n");
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
