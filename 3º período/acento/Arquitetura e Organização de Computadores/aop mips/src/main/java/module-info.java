module com.example.aop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aop to javafx.fxml;
    exports com.example.aop;
}