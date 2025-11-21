package service;

import javafx.collections.ObservableList;
import model.Suplier;

import java.sql.SQLException;

public interface SuplierService {
    void add(Suplier suplier) throws SQLException;
    void update(Suplier suplier) throws SQLException;
    void delete(String id) throws SQLException;
     String generateSupplierId() throws SQLException;
    ObservableList<Suplier> getAllSupplierDetails() throws SQLException;
}
