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
import model.Item;
import model.Suplier;
import service.ItemService;
import service.ItemServiceImpl;
import service.SuplierService;
import service.SuplierServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemManagementFormController implements Initializable {

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
    private ComboBox<String> supIdTxt;

    @FXML
    private TableView<Item> itemTbl;

    @FXML
    private Label timeLbl;
    ObservableList<Suplier>supliers= FXCollections.observableArrayList();
    SuplierService suplierService=new SuplierServiceImpl();
    ObservableList<Item>item=FXCollections.observableArrayList();
    ItemService itemService=new ItemServiceImpl();

    @FXML
    void addBtn(ActionEvent event) throws SQLException {
        String itemId=itemIdTxt.getText();
        String itemName=itemNameTxt.getText();
        double price=Double.parseDouble(priceTxt.getText());
        int Qty=Integer.parseInt(QtyTxt.getText());
        String supplierId=supIdTxt.getValue();

        Item item=new Item(
                itemId,
                itemName,
                price,
                Qty,
                supplierId
        );

        itemService.add(item);
        loadItemTable();
        clearFeilds();


    }

    @FXML
    void deleteBtn(ActionEvent event) throws SQLException {
        itemService.delete(itemIdTxt.getText());
        loadItemTable();
        clearFeilds();

    }

    @FXML
    void updateBtn(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            supliers = suplierService.getAllSupplierDetails();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        ObservableList<String>supIds=FXCollections.observableArrayList();
                for(Suplier s : supliers){
                    supIds.add(s.getId());
        }
                supIdTxt.setItems(supIds);

                itemIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
                itemNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                itemPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
                itemQtyCol.setCellValueFactory(new PropertyValueFactory<>("Qty"));
                supIdCol.setCellValueFactory(new PropertyValueFactory<>("supplierId"));

        try {
            loadItemTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        itemTbl.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if(newValue != null){
                setSelectedValue(newValue);
            }
        } );


    }

    private void loadItemTable() throws SQLException {
        itemTbl.setItems(itemService.getAllItemDetails());

    }

    private  void setSelectedValue(Item selectedValue){
        itemIdTxt.setText(selectedValue.getId());
        itemNameTxt.setText(selectedValue.getName());
        priceTxt.setText(String.valueOf(selectedValue.getPrice()));
        QtyTxt.setText(String.valueOf(selectedValue.getQty()));
        supIdTxt.setValue(selectedValue.getSupplierId());


    }
    private void clearFeilds(){
        supIdTxt.setItems(null);
        itemIdTxt.setText(null);
        itemNameTxt.setText(null);
        priceTxt.setText(null);
        QtyTxt.setText(null);
    }


}
