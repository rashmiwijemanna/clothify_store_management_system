package repository;

import model.Item;

import java.sql.ResultSet;

public interface ItemRepository {
    void add(Item item);
    void update(Item item);
    void delete(String id);
    ResultSet getAllItemDetails();
    String getLastItemId();
}
