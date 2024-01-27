module com.antoniogarciaprats.tablero {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.antoniogarciaprats.tablero to javafx.fxml;
    exports com.antoniogarciaprats.tablero;
}