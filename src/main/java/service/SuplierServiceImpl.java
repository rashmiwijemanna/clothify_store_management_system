package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employee;
import model.Suplier;
import repository.SuplierRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuplierServiceImpl implements SuplierService{
    ObservableList<Suplier>supliers= FXCollections.observableArrayList();
    SuplierRepositoryImpl suplierRepositoryImpl=new SuplierRepositoryImpl();
    @Override
    public void add(Suplier suplier) throws SQLException {
        suplierRepositoryImpl.add(suplier);


    }

    @Override
    public void update(Suplier suplier) throws SQLException {
        suplierRepositoryImpl.update(suplier);

    }

    @Override
    public void delete(String id) throws SQLException {
        suplierRepositoryImpl.delete(id);

    }

    @Override
    public String generateSupplierId() throws SQLException {
        String lastSupplierId = suplierRepositoryImpl.getLastSupplierId();
        if(lastSupplierId==null){
            return "S001";
        }
        int number = Integer.parseInt(lastSupplierId.substring(1));
        number++;
        return String.format("S%03d",number);
    }

    @Override
    public ObservableList<Suplier> getAllSupplierDetails() throws SQLException {
     supliers.clear();
        ResultSet allSupplierDetails = suplierRepositoryImpl.getAllSupplierDetails();
        while (allSupplierDetails.next()){
            supliers.add(new Suplier(
                    allSupplierDetails.getString("Id"),
                    allSupplierDetails.getString("Name"),
                    allSupplierDetails.getString("Title"),
                    allSupplierDetails.getString("Email"),
                    allSupplierDetails.getString("Company"),
                    allSupplierDetails.getString("Id")
            ));
        }
            return supliers;

    }
}
