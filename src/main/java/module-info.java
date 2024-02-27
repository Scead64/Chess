module com.chess {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.chess to javafx.fxml;
    exports com.chess;
}
