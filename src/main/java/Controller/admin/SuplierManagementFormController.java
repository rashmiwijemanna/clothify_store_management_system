package Controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Suplier;
import service.SuplierService;
import service.SuplierServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SuplierManagementFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> companyCol;

    @FXML
    private Label dateLbl;

    @FXML
    private TableColumn<?, ?> emailCol;

    @FXML
    private TableView<Suplier> suppliTbl;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> phoneNumberCol;

    @FXML
    private TextField searchTxt;

    @FXML
    private TextField subPhoneNumberTxt;

    @FXML
    private TextField supCompanyTxt;

    @FXML
    private TextField supEmailTxt;

    @FXML
    private TextField supIdTxt;

    @FXML
    private TextField supNameTxt;

    @FXML
    private ComboBox<String> supTitleTxt;

    @FXML
    private Label timeLbl;

    @FXML
    private TableColumn<?, ?> titleCol;

    ObservableList<Suplier> supliers= FXCollections.observableArrayList();
   SuplierService suplierService=new SuplierServiceImpl();

    @FXML
    void addBtn(ActionEvent event) throws SQLException {
        String supId=supIdTxt.getText();
        String supName=supNameTxt.getText();
        String supTitle=supTitleTxt.getValue();
        String supEmail=supEmailTxt.getText();
        String supCompany=supCompanyTxt.getText();
        String supPhoneNumber=subPhoneNumberTxt.getText();

        Suplier suplier=new Suplier(
                supId,
                supName,
                supTitle,
                supEmail,
                supCompany,
                supPhoneNumber
        );
        suplierService.add(suplier);

        loadSupplierTbl();
        clearFeilds();
        supIdTxt.setText(suplierService.generateSupplierId());



    }

    @FXML
    void deleteBtn(ActionEvent event) {


    }

    @FXML
    void updateBtn(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String>titleTypes=FXCollections.observableArrayList(
                "Mr",
                "Ms"

        );
        supTitleTxt.setItems(titleTypes);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        companyCol.setCellValueFactory(new PropertyValueFactory<>("company"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        try {
            loadSupplierTbl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        suppliTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue != null){
                setSelectedValue(newValue);
            }
        });



    }

    private void loadSupplierTbl() throws SQLException {
        suppliTbl.setItems(suplierService.getAllSupplierDetails());
    }
    private void setSelectedValue(Suplier selectedValue ){
        supIdTxt.setText(String.valueOf(selectedValue.getId()));
        supNameTxt.setText(String.valueOf(selectedValue.getName()));
        supTitleTxt.setValue(String.valueOf(selectedValue.getTitle()));
        supEmailTxt.setText(String.valueOf(selectedValue.getEmail()));
        supCompanyTxt.setText(String.valueOf(selectedValue.getCompany()));
        subPhoneNumberTxt.setText(String.valueOf(selectedValue.getPhoneNumber()));
    }

    private void clearFeilds(){
        supIdTxt.setText(null);
        supNameTxt.setText(null);
        supTitleTxt.setValue(null);
        supEmailTxt.setText(null);
        supCompanyTxt.setText(null);
        subPhoneNumberTxt.setText(null);
    }

}
