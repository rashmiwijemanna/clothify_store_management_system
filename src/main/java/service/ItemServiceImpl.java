package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;
import repository.ItemRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemService{
    ItemRepositoryImpl itemRepositoryImpl=new ItemRepositoryImpl();
    ObservableList<Item> item= FXCollections.observableArrayList();
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
    public ObservableList<Item> getAllItemDetails() throws SQLException {
        item.clear();
        ResultSet allItemDetails = itemRepositoryImpl.getAllItemDetails();
        while (allItemDetails.next()){
            item.add(new Item(
                    allItemDetails.getString("ItemId"),
                    allItemDetails.getString("ItemName"),
                    allItemDetails.getDouble("Price"),
                    allItemDetails.getInt("QtyOnHand"),
                    allItemDetails.getString("Id")
            ));
        }
        return item;

    }

    @Override
    public String generateItemId() {
        return "";
    }
}
