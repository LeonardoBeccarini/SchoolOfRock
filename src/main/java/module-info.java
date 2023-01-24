module com.example.schoolofrock {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.schoolofrock to javafx.fxml;
    exports com.example.schoolofrock;
}