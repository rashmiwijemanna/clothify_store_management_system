package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employee;
import model.Suplier;
import repository.SuplierRepositoryImpl;

import java.sql.SQLException;

public class SuplierServiceImpl implements SuplierService{
    ObservableList<Employee>employees= FXCollections.observableArrayList();
    SuplierRepositoryImpl suplierRepositoryImpl=new SuplierRepositoryImpl();
    @Override
    public void add(Suplier suplier) throws SQLException {
        suplierRepositoryImpl.add(suplier);


    }

    @Override
    public void update(Suplier suplier) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public String getLastSupplierId() {
        return "";
    }

    @Override
    public ObservableList<Suplier> getAllSupplierDetails() {
        return null;
    }
}
