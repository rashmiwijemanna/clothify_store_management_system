package Controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.swing.text.DateFormatter;
import java.awt.*;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class CustomerManagementFormController implements Initializable {


    public Label timeLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        LocalTime time= LocalTime.now();
//        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
//        String newTime=time.format(formatter);
//        timeLbl.setText(newTime.toString());
    }
}
