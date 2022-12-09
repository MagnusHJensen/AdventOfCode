package dk.magnusjensen.adventofcode.cal2022;

import dk.magnusjensen.adventofcode.maths.Coord;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;

import java.io.IOException;

@CalenderAssignment(calendarName = 2022, assignmentName = "", number = 16, description = "")
public class A8P2 extends Assignment {
    
    @FXML
    private TextArea output;

    public A8P2(String name) {
        super(name);
    }


    public void partOne(String input) {
        String[] lines = input.split("\n");
        int[][] map = new int[lines.length][lines[0].length()];
        for(int j = 0; j < lines.length; j++) {
            String s = lines[j];
            for(int i = 0; i < s.length(); i++) {
                map[j][i] = Integer.parseInt(s.substring(i,i+1));
            }
        }

        long bestScenic = 0;
        final Coord[] DIRS = new Coord[] {Coord.UP, Coord.DOWN, Coord.LEFT, Coord.RIGHT};
        for(int i = 0; i < map.length; i++) {
            for(int j  = 0; j < map[i].length; j++) {
                int curHeight = map[i][j];
                long scenic = 1;
                inner:
                for(Coord dir : DIRS) {
                    long dist = 0;
                    Coord cur = new Coord(i,j);
                    cur.sumSelf(dir);
                    while(cur.x > -1 && cur.y > -1 && cur.x < map.length && cur.y < map[i].length) {
                        dist++;
                        if(map[cur.x][cur.y] >= curHeight) {
                            break;
                        }
                        cur.sumSelf(dir);
                    }
                    scenic *= dist;
                }
                bestScenic = Math.max(scenic,bestScenic);
            }
        }

        output.setText("Best scenic: " + bestScenic);
    }
}
