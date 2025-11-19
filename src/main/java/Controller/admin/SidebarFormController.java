package Controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SidebarFormController implements Initializable {
    Stage stage=new Stage();

    @FXML
    private AnchorPane loadUi;

    @FXML
    void customerManagementBtn(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/Admin/CustomerManagement.fxml"));
        loadUi.getChildren().setAll(pane);



    }

    @FXML
    void employeeManagementBtn(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("/view/Admin/EmployeeManagement.fxml"));
        loadUi.getChildren().setAll(pane);

    }

    @FXML
    void itemManagementBtn(ActionEvent event) {

    }

    @FXML
    void reportViewBtn(ActionEvent event) {

    }

    @FXML
    void suplierManagementBtn(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnchorPane pane= null;
        try {
            pane = FXMLLoader.load(getClass().getResource("/view/Admin/EmployeeManagement.fxml"));
            loadUi.getChildren().setAll(pane);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
