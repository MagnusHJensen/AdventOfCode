package dk.magnusjensen.adventofcode.templates;


import dk.magnusjensen.adventofcode.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public abstract class Assignment {

    @FXML
    private TextArea input;
    private String name;
    @FXML
    private Label outputLabel;

    public Assignment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, this.getClass().getAnnotation(CalenderAssignment.class).calendarName(), Math.round(this.getClass().getAnnotation(CalenderAssignment.class).number() / 2f));
        return content;
    };

    protected Node loadContent(String fxml, Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        loader.setController(controller);
        return loader.load();
    }

    protected Node loadDefaultContent (Assignment controller) throws IOException {
        return loadContent("defaultContent", controller);
    }

    protected void setInputContent(TextArea input, int calenderNumber, int day) throws IOException {
        Path inputPath = Path.of("./input/", calenderNumber + "/", day + ".txt");
        if (inputPath.toFile().exists()) {
            Scanner scanner = new Scanner(Path.of("./input/", calenderNumber + "/", day + ".txt"));
            while (scanner.hasNextLine()) {
                input.appendText(scanner.nextLine() + "\n");
            }
        }
    }

    public void run(ActionEvent actionEvent) {
        long start = System.nanoTime();
        partOne(input.getText());
        long end = System.nanoTime();
        outputLabel.setText("Output - Execution Time: " + (end - start) / 1_000_000d + " seconds");
    }

    protected abstract void partOne(String input);

    @Override
    public String toString() {
        return name;
    }
}
