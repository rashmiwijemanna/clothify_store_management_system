package Controller.employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerManagementFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> custAddressCol;

    @FXML
    private TableColumn<?, ?> custCityCol;

    @FXML
    private TableColumn<?, ?> custDobCol;

    @FXML
    private TableColumn<?, ?> custEmailCol;

    @FXML
    private TableColumn<?, ?> custIdCol;

    @FXML
    private TableColumn<?, ?> custNameCol;

    @FXML
    private TableColumn<?, ?> custPhoneNumberCol;

    @FXML
    private TableColumn<?, ?> custTitleCol;

    @FXML
    private TableView<Customer> customerTblEmp;

    @FXML
    private Label dateLbl;

    @FXML
    private Label timeLbl;

    Stage stage=new Stage();

    ObservableList<Customer> customers= FXCollections.observableArrayList();
    CustomerService customerService=new CustomerServiceImpl();

    @FXML
    void addNewCustomerBtn(ActionEvent event) throws IOException, SQLException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddCustomerForm.fxml"))));
        stage.show();
        stage.setOnHiding(windowEvent -> {
            try {
                loadCustomerTbl();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        custIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        custTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        custNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        custDobCol.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        custPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        custEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        custAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        custCityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        try {
            loadCustomerTbl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void loadCustomerTbl() throws SQLException {
        customers.clear();
        customers.addAll(customerService.getAllCustDetails());
        customerTblEmp.setItems(customers);

    }
}
