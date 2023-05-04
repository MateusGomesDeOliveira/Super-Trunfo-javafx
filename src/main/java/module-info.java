module mateus.final_super_trunfo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.almasb.fxgl.all;
    
    opens mateus.final_super_trunfo to javafx.fxml;
    exports mateus.final_super_trunfo;
}