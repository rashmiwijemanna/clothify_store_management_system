package service;

import javafx.collections.ObservableList;
import model.Item;
import model.Suplier;

import java.sql.SQLException;

public interface ItemService {
    void add(Item item) throws SQLException;
    void update(Item item);
    void delete(String id);
    ObservableList<Item>getAllItemDetails();
    String generateItemId();

}
