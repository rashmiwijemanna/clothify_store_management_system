package Controller.admin;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeManagementFormController implements Initializable {
    ObservableList<Employee>employees= FXCollections.observableArrayList();
    EmployeeService employeeService=new EmployeeServiceImpl();

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private Label dateLbl;

    @FXML
    private TableColumn<?, ?> emailCol;

    @FXML
    private TextField empAddressTxt;

    @FXML
    private TextField empEmailTxt;

    @FXML
    private TextField empIdTxt;

    @FXML
    private TextField empNameTxt;

    @FXML
    private TextField empPasswordTxt;

    @FXML
    private TextField empPhoneNumberTxt;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> passwordCol;

    @FXML
    private TableColumn<?, ?> phoneNumberCol;

    @FXML
    private Label timeLbl;
    @FXML
    private TableView<Employee> employeeTbl;

    @FXML
    void addBtn(ActionEvent event) throws SQLException {
        String empId=empIdTxt.getText();
        String empName=empNameTxt.getText();
        String empEmail=empEmailTxt.getText();
        String empPassword=empPasswordTxt.getText();
        String empaAddress=empAddressTxt.getText();
        String empPhoneNumber=empPhoneNumberTxt.getText();
        Employee employee=new Employee(
                empId,
                empName,
                empEmail,
                empPassword,
                empaAddress,
                empPhoneNumber
        );

       employeeService.add(employee);
       loadEmployeeDetails();


    }

    @FXML
    void clearBtn(ActionEvent event) {

    }

    @FXML
    void deleteBtn(ActionEvent event) {

    }

    @FXML
    void updateBtn(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        try {
            loadEmployeeDetails();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        employeeTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if(newValue != null){
                setSelectedValue(newValue);
            }
        } );


    }

    private void setSelectedValue(Employee selectedValue){
        empIdTxt.setText(String.valueOf(selectedValue.getId()));
        empNameTxt.setText(String.valueOf(selectedValue.getName()));
        empEmailTxt.setText(String.valueOf(selectedValue.getEmail()));
        empPasswordTxt.setText(String.valueOf(selectedValue.getPassword()));
        empAddressTxt.setText(String.valueOf(selectedValue.getAddress()));
        empPhoneNumberTxt.setText(String.valueOf(selectedValue.getPhoneNumber()));
    }

    private void loadEmployeeDetails() throws SQLException {
        employees.clear();
        employeeTbl.setItems(employeeService.getAllEmployeeDetails());

    }

}
