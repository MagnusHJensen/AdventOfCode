package org.adventofcode.templates;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import org.adventofcode.App;
import org.atteo.classindex.ClassIndex;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class Calendar extends Tab implements Initializable {

    private ObservableList<Assignment> assignments;
    private String name;

    private CalenderAssignment currentAnnotation;

    @FXML
    private BorderPane calendarRoot;
    @FXML
    private ListView<Assignment> assignmentList;

    public Calendar(String name) throws IOException {
        super(name);
        this.name = name;
        currentAnnotation = null;
        assignments = FXCollections.observableArrayList();
        loadAssignments();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("calendar.fxml"));
        fxmlLoader.setController(this);
        setContent(fxmlLoader.load());
    }

    private void loadAssignments () {
        Iterable<Class<?>> classes = ClassIndex.getAnnotated(CalenderAssignment.class);
        TreeMap<Integer, Assignment> assignmentMap = new TreeMap<>();

        DecimalFormat df = new DecimalFormat("0");
        for (Class<?> c : classes) {
            CalenderAssignment ca = (CalenderAssignment) c.getAnnotationsByType(CalenderAssignment.class)[0];
            if (ca.calendarName().equals(name)) {
                try {
                    float cnt = (float)Math.ceil((double)ca.number() * 0.5d);
                    assignmentMap.put(ca.number(), (Assignment) c.getDeclaredConstructor(String.class).newInstance(df.format(cnt) +(ca.number() % 2 == 0 ? "B": "A")+ ") " + ca.assignmentName()));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int key : assignmentMap.keySet()) {
            assignments.add(assignmentMap.get(key));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assignmentList.setItems(assignments);
        assignmentList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Assignment>() {
            @Override
            public void changed(ObservableValue<? extends Assignment> observableValue, Assignment assignment, Assignment t1) {
                try {
                    calendarRoot.setCenter(t1.getContent());
                    currentAnnotation = t1.getClass().getAnnotation(CalenderAssignment.class);
                } catch (IOException e) {
                    calendarRoot.setCenter(new Label(e.toString()));
                    e.printStackTrace();
                }
            }
        });
        assignmentList.getSelectionModel().selectFirst();
    }

    @FXML
    private void showDescription (ActionEvent event) {
        if (currentAnnotation == null)
            return;

        Alert desc = new Alert(Alert.AlertType.INFORMATION);
        desc.setHeaderText(null);
        desc.setTitle("Task");
        desc.setContentText(currentAnnotation.description());
        desc.initModality(Modality.APPLICATION_MODAL);
        desc.showAndWait();
    }
}
