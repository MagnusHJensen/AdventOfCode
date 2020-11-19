module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires classindex;
    requires json.simple;
    
    opens org.adventofcode to javafx.fxml;
    opens org.adventofcode.templates to javafx.fxml;
    opens org.adventofcode.cal2015 to javafx.fxml;
    opens org.adventofcode.cal2016 to javafx.fxml;
    opens org.adventofcode.math to javafx.fxml;
    opens org.adventofcode.utils to javafx.fxml;
    opens org.adventofcode.logiccircuit to javafx.fxml;
    opens org.adventofcode.graph to javafx.fxml;
    exports org.adventofcode;
    
}