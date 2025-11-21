package Controller.employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private TextField custAddressTxt;

    @FXML
    private TextField custCity;

    @FXML
    private DatePicker custDOBTxt;

    @FXML
    private TextField custEmailTxt;

    @FXML
    private TextField custIdTxt;

    @FXML
    private TextField custNameTxt;

    @FXML
    private TextField custPhoneNumberTxt;

    @FXML
    private ComboBox<String> custTitleTxt;

    @FXML
    private Label dateLbl;

    @FXML
    private Label timeLbl;
    ObservableList<Customer>customers= FXCollections.observableArrayList();
    CustomerService customerService=new CustomerServiceImpl();


    @FXML
    void addBtn(ActionEvent event) throws SQLException {
        String id=custIdTxt.getText();
        String title=custTitleTxt.getValue();
        String name=custNameTxt.getText();
        LocalDate dob=custDOBTxt.getValue();
        String phoneNumber=custPhoneNumberTxt.getText();
        String email=custEmailTxt.getText();
        String address=custAddressTxt.getText();
        String city=custCity.getText();
        Customer customer=new Customer(
                id,
                title,
                name,
                dob,
                phoneNumber,
                email,
                address,
                city
        );
        customerService.add(customer);




    }

    @FXML
    void viewBtn(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            custIdTxt.setText(customerService.generateCustId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<String >types=FXCollections.observableArrayList(
                "Mr",
                "Ms"

        );
        custTitleTxt.setItems(types);

    }
}
