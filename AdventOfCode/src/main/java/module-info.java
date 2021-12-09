module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires classindex;
    requires json.simple;
    
    opens org.adventofcode to javafx.fxml;
    opens org.adventofcode.templates to javafx.fxml;
    opens org.adventofcode.cal2015 to javafx.fxml;
    opens org.adventofcode.cal2020 to javafx.fxml;
    opens org.adventofcode.cal2021 to javafx.fxml;
    opens org.adventofcode.maths to javafx.fxml;
    exports org.adventofcode;
    opens org.adventofcode.cal2021.day_five to javafx.fxml;

}