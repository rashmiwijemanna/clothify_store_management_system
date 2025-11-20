package Controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ItemManagementFormController {

    @FXML
    private TextField QtyTxt;

    @FXML
    private Label dateLbl;

    @FXML
    private TableColumn<?, ?> itemIdCol;

    @FXML
    private TextField itemIdTxt;

    @FXML
    private TableColumn<?, ?> itemNameCol;

    @FXML
    private TextField itemNameTxt;

    @FXML
    private TableColumn<?, ?> itemPriceCol;

    @FXML
    private TableColumn<?, ?> itemQtyCol;

    @FXML
    private TextField priceTxt;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableColumn<?, ?> supIdCol;

    @FXML
    private ComboBox<?> supIdTxt;

    @FXML
    private TableView<?> suppliTbl;

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
