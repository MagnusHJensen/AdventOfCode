package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 23, description = "")
public class A12P1 extends Assignment {

    @FXML
    private TextArea output;

    public A12P1(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] data = input.split("\n");
        Point start = new Point(-1, -1);
        Point end  = new Point(-1, -1);;

        int[][] heightMap = new int[data.length][data[0].length()];
        for(int x = 0; x< data.length; x++) {
            char[] heights = data[x].toCharArray();
            for(int y = 0; y<heights.length; y++ ) {

                if(heights[y] >= 'a' && heights[y] <= 'z') {
                    heightMap[x][y] = heights[y] - 'a';
                } else if(heights[y] == 'S') {
                    heightMap[x][y] = '0';
                    start = new Point(x, y);
                } else {
                    heightMap[x][y] = 25;
                    end = new Point(x, y);
                }
            }
        }



        Set<Point> previouslyVisited = new HashSet<>();
        Set<Point> currentLevel = new HashSet<>();
        Set<Point> nextLevel = new HashSet<>();
        currentLevel.add(start);
        int level = 0;

        gotoFun: while(true) {
            for(Point p : currentLevel) {
                if(p.equals(end)) {
                    break gotoFun;
                }
                nextLevel.addAll(p.validRoutes(heightMap).stream().filter(x -> !previouslyVisited.contains(x)).toList());
                previouslyVisited.add(p);
            }
            level++;
            currentLevel = nextLevel;
            nextLevel = new HashSet<>();
        }
        System.out.println(level);



    }

    record Point(int x, int y) {
        static List<Point> dirs = List.of(new Point(-1, 0),
            new Point(0, -1),  new Point(0, 1),
            new Point(1, 0));

        List<Point> validRoutes(int[][] heightMap) {
            return dirs.stream().map(x -> x.add(this))
                .filter(x -> x.inBounds(heightMap.length, heightMap[0].length))
                .filter(x -> x.isReachableFrom(this, heightMap))
                .toList();
        }

        boolean isReachableFrom(Point previousPoint, int[][] heightMap) {
            int currentHeight = heightMap[previousPoint.x()][previousPoint.y()];
            int newHeight = heightMap[x()][y()];
            return newHeight<=currentHeight+1;
        }

        boolean inBounds(int maxX, int maxY) {
            return (x>=0 && x<maxX && y>0 && y<maxY);
        }

        Point add(Point p) {
            return new Point(x + p.x(), y + p.y());
        }
    }

}
