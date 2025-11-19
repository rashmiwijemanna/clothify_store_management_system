package repository;

import javafx.collections.ObservableList;
import model.Suplier;

import java.sql.SQLException;

public interface SuplierRepository {
    void add(Suplier suplier) throws SQLException;
    void update(Suplier suplier);
    void delete(String id);
    String getLastSupplierId();
    ObservableList<Suplier> getAllSupplierDetails();
}
