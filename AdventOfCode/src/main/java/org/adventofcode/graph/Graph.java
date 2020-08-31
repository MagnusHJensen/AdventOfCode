package org.adventofcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Object, Node> nodes;
    private Map<Node, List<Edge>> edgesFrom;
    private Map<Node, List<Edge>> edgesTo;

    private boolean directional;

    public Graph (boolean directional) {
        nodes = new HashMap<>();
        edgesFrom = new HashMap<>();
        edgesTo = new HashMap<>();
        this.directional = directional;
    }

    public <T> Node createNode (T nodeValue) {
        if (nodes.containsKey(nodeValue)) {
            return nodes.get(nodeValue);
        }

        Node n = new Node(new ValueObject<>(nodeValue));
        nodes.put(nodeValue, n);
        edgesFrom.put(n, new ArrayList<>());
        edgesTo.put(n, new ArrayList<>());
        return n;
    }

    public <T> void removeNode (T nodeValue) {
        Node removed = nodes.remove(nodeValue);
        edgesFrom.remove(removed);
        edgesTo.remove(removed);
    }

    public <T> Node getNode (T nodeName) {
        return nodes.get(nodeName);
    }

    public <T> boolean createEdge (T from, T to) {
        return createEdge(from, to, 1);
    }

    public <T> boolean createEdge (T from, T to, int weight) {
        Node node1 = nodes.get(from);
        Node node2 = nodes.get(to);

        if (node1 != null && node2 != null) {
            Edge edge = new Edge(node1, node2, weight);
            edgesFrom.get(node1).add(edge);
            edgesTo.get(node2).add(edge);
        }

        return false;
    }

    public <T> void removeEdge (T from, T to) {
        Node node1 = nodes.get(from);
        Node node2 = nodes.get(to);

        if (node1 != null && node2 != null) {
            Edge toRemove = null;
            for (Edge edge : edgesFrom.get(node1)) {
                if (edge.getEnd() == node2) {
                    toRemove = edge;
                    break;
                }
            }
            if (toRemove != null) {
                edgesFrom.get(node1).remove(toRemove);
            }

            toRemove = null;
            for (Edge edge : edgesTo.get(node2)) {
                if (edge.getStart() == node1) {
                    toRemove = edge;
                    break;
                }
            }
            if (toRemove != null) {
                edgesFrom.get(node2).remove(toRemove);
            }
        }
    }

    public boolean isDirectional () {
        return directional;
    }

    protected List<Edge> getEdgesFrom (Node from) {
        return edgesFrom.get(from);
    }

    protected List<Edge> getEdgesTo (Node to) {return edgesTo.get(to);}

    protected List<Node> getAllNodes () {
        List<Node> nodeList = new ArrayList<>();
        for (Map.Entry<Object, Node> entry : nodes.entrySet()) {
            nodeList.add(entry.getValue());
        }
        return nodeList;
    }
}
