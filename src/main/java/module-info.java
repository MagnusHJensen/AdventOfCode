module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires classindex;
    requires json.simple;
    
    opens dk.magnusjensen.adventofcode to javafx.fxml;
    opens dk.magnusjensen.adventofcode.templates to javafx.fxml;
    opens dk.magnusjensen.adventofcode.cal2015 to javafx.fxml;
    opens dk.magnusjensen.adventofcode.cal2018 to javafx.fxml;
    opens dk.magnusjensen.adventofcode.cal2020 to javafx.fxml;
    opens dk.magnusjensen.adventofcode.cal2021 to javafx.fxml;
    opens dk.magnusjensen.adventofcode.cal2021.day_five to javafx.fxml;
    opens dk.magnusjensen.adventofcode.cal2022 to javafx.fxml;
    opens dk.magnusjensen.adventofcode.maths to javafx.fxml;

    exports dk.magnusjensen.adventofcode;
}