package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 13, description = "")
public class A7P1 extends Assignment {
    
    @FXML
    private TextArea output;

    public A7P1(String name) {
        super(name);
    }

    public void partOne(String input) {
        String[] lines = input.split("\n");

        Node root = new Node("/", null);
        Node pointer = root;

        for (String line : lines) {
            String[] parts = line.split(" ");

            if (parts[1].equals("ls")) {

            } else if (parts[1].equals("cd")) {
                if (parts[2].equals("/")) {
                    pointer = root;
                } else if (parts[2].equals("..")) {
                    pointer = pointer.getParent();
                } else {
                    pointer = pointer.getChildren().stream().filter((node -> node.getName().equals(parts[2]))).toList().get(0);
                }
            } else if (parts[0].equals("dir")) {
                pointer.getChildren().add(new Node(parts[1], pointer));
            } else {
                pointer.getFiles().add(new FileNode(parts[1], Integer.parseInt(parts[0])));
            }
        }

        setSizes(root);

        List<Node> smallNodes = getSmallNodes(root, 100_000);


        output.setText("Output: " + smallNodes.stream().mapToInt(Node::getSize).sum());
    }

    public int setSizes(Node node) {
        int total = node.getChildren().stream().mapToInt((dirNode) -> setSizes(dirNode)).sum() + node.getFiles().stream().mapToInt((file) -> file.getSize()).sum();
        node.setSize(total);
        return total;
    }

    public List<Node> getSmallNodes(Node node, int threshold) {
        List<Node> nodes = new ArrayList<>();
        for (Node child : node.getChildren()) {
            nodes.addAll(getSmallNodes(child, threshold));
        }

        if (node.getSize() < threshold) {
            nodes.add(node);
        }

        return nodes;
    }


    public class FileNode {
        private int size;
        private String name;

        public FileNode(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }
    }

    public class Node {
        private String name;
        private Node parent;
        private List<Node> children = new ArrayList<>();
        private List<FileNode> files = new ArrayList<>();
        private int size = 0;

        public Node(String name, Node parent) {
            this.name = name;
            this.parent = parent;
        }


        public String getName() {
            return name;
        }

        public Node getParent() {
            return parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public List<FileNode> getFiles() {
            return files;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
