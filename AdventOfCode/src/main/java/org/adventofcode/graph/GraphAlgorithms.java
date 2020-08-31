package org.adventofcode.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphAlgorithms {
    private GraphAlgorithms () {}

    public static <T> double shortestPath (Graph graph, T nodeNameFrom, T nodeNameTo) {

        //Initialize
        for (Node n : graph.getAllNodes()) {
            if (n.getValue() == nodeNameFrom) {
                n.setAttribute("distance", 0d);
                n.setAttribute("discovered", true);
            }
            else {
                n.setAttribute("distance", Double.POSITIVE_INFINITY);
                n.setAttribute("discovered", false);
            }
        }


        LinkedList<Node> queue = new LinkedList<>();
        queue.add(graph.getNode(nodeNameFrom));

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            for (Edge edge : graph.getEdgesFrom(current)) {
                //add if not discovered
                if (!(boolean)edge.getEnd().getAttribute("discovered")) {
                    queue.add(edge.getEnd());
                }

                //Update distance
                if ((double)edge.getEnd().getAttribute("distance") > (double)current.getAttribute("distance") + edge.getWeight()) {
                    edge.getEnd().setAttribute("distance", (double)current.getAttribute("distance") + edge.getWeight());
                    edge.getEnd().setAttribute("discovered", true);
                }
            }
            if (!graph.isDirectional()) {
                for (Edge edge : graph.getEdgesTo(current)) {
                    //add if not discovered
                    if (!(boolean)edge.getStart().getAttribute("discovered")) {
                        queue.add(edge.getStart());
                    }

                    //Update distance
                    if ((double)edge.getStart().getAttribute("distance") > (double)current.getAttribute("distance") + edge.getWeight()) {
                        edge.getStart().setAttribute("distance", (double)current.getAttribute("distance") + edge.getWeight());
                        edge.getStart().setAttribute("discovered", true);
                    }
                }
            }
        }

        return graph.getNode(nodeNameTo).getAttribute("distance");
    }
}
