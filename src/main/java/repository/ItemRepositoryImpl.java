package repository;

import db.DBConnection;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositoryImpl implements ItemRepository{
    @Override
    public void add(Item item) throws SQLException {
        String sql="INSERT INTO Item(ItemId, ItemName, Price, QtyOnHand, Id) VALUES (?,?,?,?,?);";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,item.getId());
        preparedStatement.setObject(2,item.getName());
        preparedStatement.setObject(3,item.getPrice());
        preparedStatement.setObject(4,item.getQty());
        preparedStatement.setObject(5,item.getSupplierId());

        preparedStatement.executeUpdate();


    }

    @Override
    public void update(Item item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ResultSet getAllItemDetails() throws SQLException {
        String sql="SELECT * FROM Item";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public String getLastItemId() {
        return "";
    }
}
