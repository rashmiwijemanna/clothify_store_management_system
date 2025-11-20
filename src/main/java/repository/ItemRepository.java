package repository;

import model.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {
    void add(Item item) throws SQLException;
    void update(Item item);
    void delete(String id) throws SQLException;
    ResultSet getAllItemDetails() throws SQLException;
    String getLastItemId();
}
