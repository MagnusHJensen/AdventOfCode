package dk.magnusjensen.adventofcode;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CalendarGenerator {
    public static void main(String[] args) {
        int year = 2023;
        String classFile = """
            package dk.magnusjensen.adventofcode.cal$YEAR;
                        
            import dk.magnusjensen.adventofcode.templates.Assignment;
            import dk.magnusjensen.adventofcode.templates.CalenderAssignment;
            import javafx.fxml.FXML;
            import javafx.scene.control.TextArea;
                        
            @CalenderAssignment(calendarName = $YEAR, assignmentName = "$NAME", number = $NUMBER, description = "")
            public class $NAME extends Assignment {
                        
                @FXML
                private TextArea output;
                        
                public $NAME(String name) {
                    super(name);
                }
                        
                @Override
                protected void partOne(String input) {
                   \s
                }
            }
            """;

        for (int i = 0; i < 50; i++) {
            String name = "A" + (int) Math.ceil((i + 1) / 2.0F) + "P" + (i % 2 + 1);
            String number = String.valueOf(i + 1);
            String file = classFile
                .replaceAll("\\$YEAR", String.valueOf(year))
                .replaceAll("\\$NAME", name)
                .replaceAll("\\$NUMBER", number);

            // Write java file.
            try (PrintWriter writer = new PrintWriter("src/main/java/dk/magnusjensen/adventofcode/cal" + year + "/" + name + ".java")) {
                writer.println(file);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Only create 25 input files.
            if (i >= 25) {
                continue;
            }

            try {
                new File("input/" + year + "/" + number + ".txt").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
