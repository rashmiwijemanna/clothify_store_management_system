package Controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;

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
    ObservableList<Customer>customer= FXCollections.observableArrayList();
    CustomerService customerService=new CustomerServiceImpl();

    @FXML
    void addBtn(ActionEvent event) throws SQLException {
        String id= custIdTxt.getText();
        String titile= String.valueOf(custTitle.getValue());
        String name=custNameTxt.getText();
       LocalDate dob= custDOBTxt.getValue();
       String phoneNumber=custPhoneNumberTxt.getText();
       String email=custEmailTxt.getText();
       String address=custAddressTxt.getText();
       String city=custCity.getText();

       Customer customer1=new Customer(
               id,
               titile,
               name,
               dob,
               phoneNumber,
               email,
               address,
               city
       );
       customerService.add(customer1);




    }

    @FXML
    void deleteBtn(ActionEvent event) {

    }

    @FXML
    void updateBtn(ActionEvent event) {

    }

}
