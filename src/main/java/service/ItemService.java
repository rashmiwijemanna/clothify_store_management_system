package service;

import javafx.collections.ObservableList;
import model.Item;
import model.Suplier;

import java.sql.SQLException;

public interface ItemService {
    void add(Item item) throws SQLException;
    void update(Item item) throws SQLException;
    void delete(String id) throws SQLException;
    ObservableList<Item>getAllItemDetails() throws SQLException;
    String generateItemId();

}
