package Controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerManagementFormController {

    @FXML
    private TableColumn<?, ?> custAddressCol;

    @FXML
    private TextField custAddressTxt;

    @FXML
    private TextField custCity;

    @FXML
    private TableColumn<?, ?> custCityCol;

    @FXML
    private DatePicker custDOBTxt;

    @FXML
    private TableColumn<?, ?> custDobCol;

    @FXML
    private TableColumn<?, ?> custEmailCol;

    @FXML
    private TextField custEmailTxt;

    @FXML
    private TableColumn<?, ?> custIdCol;

    @FXML
    private TextField custIdTxt;

    @FXML
    private TableColumn<?, ?> custNameCol;

    @FXML
    private TextField custNameTxt;

    @FXML
    private TableColumn<?, ?> custPhoneNumberCol;

    @FXML
    private TextField custPhoneNumberTxt;

    @FXML
    private ComboBox<?> custTitle;

    @FXML
    private TableColumn<?, ?> custTitleCol;

    @FXML
    private TableView<?> customerTbl;

    @FXML
    private Label dateLbl;

    @FXML
    private TextField searchTxt;

    @FXML
    private Label timeLbl;

    @FXML
    void addBtn(ActionEvent event) {

    }

    @FXML
    void deleteBtn(ActionEvent event) {

    }

    @FXML
    void updateBtn(ActionEvent event) {

    }

}
