package Controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerManagementFormController implements Initializable {

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
    private ComboBox<String> custTitle;

    @FXML
    private TableColumn<?, ?> custTitleCol;

    @FXML
    private TableView<Customer> customerTbl;

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
       loadTable();
       clearFeilds();
       generateCustId();




    }

    @FXML
    void deleteBtn(ActionEvent event) throws SQLException {
        customerService.delete(custIdTxt.getText());
        loadTable();
        clearFeilds();
        generateCustId();

    }

    @FXML
    void updateBtn(ActionEvent event) throws SQLException {
        String id=custIdTxt.getText();
        String title=custTitle.getValue();
        String name=custNameTxt.getText();
        LocalDate DOB= custDOBTxt.getValue();
        String phoneNumber=custPhoneNumberTxt.getText();
        String email=custEmailTxt.getText();
        String address=custAddressTxt.getText();
        String city=custCity.getText();

        Customer customer1=new Customer(
                id,
                title,
                name,
                DOB,
                phoneNumber,
                email,
                address,
                city
        );
        customerService.update(customer1);
        loadTable();
        clearFeilds();
        generateCustId();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String >types=FXCollections.observableArrayList(
                "Mr",
                "Ms"

        );
        custTitle.setItems(types);
        try {
            generateCustId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        custIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        custTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        custNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        custDobCol.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        custPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        custEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        custAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        custCityCol.setCellValueFactory(new PropertyValueFactory<>("city"));

        try {
            loadTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        customerTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if(newValue != null){
                setSelectedValue(newValue);
            }
        } );

    }
    private void setSelectedValue(Customer selectedValue){
        custIdTxt.setText(selectedValue.getId());
        custTitle.setValue(selectedValue.getTitle());
        custNameTxt.setText(selectedValue.getName());
        custDOBTxt.setValue(selectedValue.getDOB());
        custPhoneNumberTxt.setText(selectedValue.getPhoneNumber());
        custEmailTxt.setText(selectedValue.getEmail());
        custAddressTxt.setText(selectedValue.getAddress());
        custCity.setText(selectedValue.getCity());


    }

    private void loadTable() throws SQLException {

        customerTbl.setItems(customerService.getAllCustDetails());
    }
    private void clearFeilds(){
        custIdTxt.setText(null);
        custTitle.setValue(null);
        custNameTxt.setText(null);
        custDOBTxt.setValue(null);
        custPhoneNumberTxt.setText(null);
        custEmailTxt.setText(null);
        custAddressTxt.setText(null);
        custCity.setText(null);
    }
    private void generateCustId() throws SQLException {

        custIdTxt.setText(customerService.generateCustId());
    }
}
