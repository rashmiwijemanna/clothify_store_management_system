package service;

import javafx.collections.ObservableList;
import model.Item;
import model.Suplier;

public interface ItemService {
    void add(Item item);
    void update(Item item);
    void delete(String id);
    ObservableList<Item>getAllItemDetails();
    String generateItemId();

}
