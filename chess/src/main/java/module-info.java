module chess.com {
    requires javafx.controls;
    requires javafx.fxml;

    opens chess.com to javafx.fxml;
    exports chess.com;
}
