package service;

import javafx.collections.ObservableList;
import model.Item;
import repository.ItemRepositoryImpl;

import java.sql.SQLException;

public class ItemServiceImpl implements ItemService{
    ItemRepositoryImpl itemRepositoryImpl=new ItemRepositoryImpl();
    @Override
    public void add(Item item) throws SQLException {
        itemRepositoryImpl.add(item);

    }

    @Override
    public void update(Item item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ObservableList<Item> getAllItemDetails() {
        return null;
    }

    @Override
    public String generateItemId() {
        return "";
    }
}
