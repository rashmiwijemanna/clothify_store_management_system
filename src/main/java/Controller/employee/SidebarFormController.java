package Controller.employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SidebarFormController implements Initializable {

    @FXML
    private AnchorPane loadUi;







    @FXML
    void customerManagementBtn(ActionEvent event) throws IOException {
       AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/CustomerManagementEmp.fxml"));
       loadUi.getChildren().setAll(pane);



    }

    @FXML
    void itemManagementBtn(ActionEvent event) {

    }

    @FXML
    void placeOrderBtn(ActionEvent event) {

    }

    @FXML
     void viewOrderBtn(ActionEvent actionEvent) {
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(getClass().getResource("/view/CustomerManagementEmp.fxml"));
            loadUi.getChildren().setAll(pane);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
