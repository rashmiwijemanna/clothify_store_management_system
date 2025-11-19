package repository;

import javafx.collections.ObservableList;
import model.Suplier;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SuplierRepository {
    void add(Suplier suplier) throws SQLException;
    void update(Suplier suplier);
    void delete(String id) throws SQLException;
    String getLastSupplierId() throws SQLException;
   ResultSet getAllSupplierDetails() throws SQLException;
}
