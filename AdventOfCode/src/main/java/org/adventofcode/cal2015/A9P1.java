package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.graph.Graph;
import org.adventofcode.graph.GraphAlgorithms;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;
import org.adventofcode.utils.ListUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Consumer;

@CalenderAssignment(calendarName = "2015", assignmentName = "Shortest Path", number = 17, description = "Get list of distances between nodes\nWhat is the shortest path that visits all notes once?")
public class A9P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A9P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String[] lines = input.getText().split("\n");
        Graph graph = new Graph(false);
        Set<String> cities = new HashSet<>();

        for (String line : lines) {
            String[] tokens = line.split(" ");
            graph.createNode(tokens[0]);
            cities.add(tokens[0]);
            graph.createNode(tokens[2]);
            cities.add(tokens[2]);
            int dist = Integer.parseInt(tokens[4]);
            graph.createEdge(tokens[0], tokens[2], dist);
        }

        //Cache Distances
        Map<String, Map<String, Double>> shortestPaths = new HashMap<>();
        for (String city : cities) {
            shortestPaths.put(city, new HashMap<>());

            for (String city2 : cities) {
                if (city.equals(city2)) {
                    continue;
                }

                double shortest = GraphAlgorithms.shortestPath(graph, city, city2);
                shortestPaths.get(city).put(city2, shortest);
            }
        }

        List<List<String>> permutations = ListUtils.generateAllPermutations(new ArrayList<>(cities));

        double minDist = Double.POSITIVE_INFINITY;
        for (List<String> cityList : permutations) {
            int totalDist = 0;
            for (int i = 0; i < cityList.size()-1; i++) {
                totalDist += shortestPaths.get(cityList.get(i)).get(cityList.get(i+1));
            }

            if (totalDist < minDist) {
                minDist = totalDist;
            }
        }



        output.setText("length of shortest path: " + minDist);
    }




}
