package dk.magnusjensen.adventofcode.cal2018;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CalenderAssignment(calendarName = "2018", assignmentName = "", number = 4)
public class A2P2 extends Assignment {
    @FXML
    private TextArea input;
    @FXML
    private TextArea output;
    @FXML
    private Label outputLabel;

    public A2P2(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        Node content = loadDefaultContent(this);
        setInputContent(input, 2018, 2);
        return content;
    }

    @FXML
    public void run(ActionEvent event) {
        long start = System.currentTimeMillis();
        String[] lines = input.getText().split("\n");

        List<String> ids = new ArrayList<>(List.of(lines));
        String finalString = "";
        outer:
        for (String id : ids) {
            for (String id2 : ids) {
                if (id2.equals(id)) continue;

                char[] idLetters = id.toCharArray();
                char[] id2Letters = id2.toCharArray();
                StringBuilder charactersDeviating = new StringBuilder();
                int deviationCount = 0;
                for (int i = 0; i < idLetters.length; i++) {
                    if (idLetters[i] != id2Letters[i]) {
                        deviationCount++;
                        charactersDeviating.append(idLetters[i]);
                    }

                    if (deviationCount > 1) {
                        break;
                    }

                    if (deviationCount == 1 && i == idLetters.length -1) {
                        finalString = id.replace(charactersDeviating.toString(), "");
                        break outer;
                    }
                }
            }
        }

        long stop = System.currentTimeMillis();

        outputLabel.setText("Output - Execution time: " + (stop - start) + "ms");
        output.setText(String.format("Output: %s", finalString));
    }
}
