package repository;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.Suplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuplierRepositoryImpl implements SuplierRepository {

    @Override
    public void add(Suplier suplier) throws SQLException {
        String sql="INSERT INTO Supplier(Id, Name, Title, Email, Company, PhoneNumber) VALUES (?,?,?,?,?,?);";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,suplier.getId());
        preparedStatement.setObject(2,suplier.getName());
        preparedStatement.setObject(3,suplier.getTitle());
        preparedStatement.setObject(4,suplier.getEmail());
        preparedStatement.setObject(5,suplier.getCompany());
        preparedStatement.setObject(6,suplier.getPhoneNumber());
        preparedStatement.executeUpdate();

    }

    @Override
    public void update(Suplier suplier) {

    }

    @Override
    public void delete(String id) throws SQLException {
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM Supplier WHERE Id = ?");
        preparedStatement.setObject(1,id);
        preparedStatement.executeUpdate();


    }

    @Override
    public String getLastSupplierId() throws SQLException {
      String sql="SELECT Id FROM Supplier ORDER BY Id DESC LIMIT 1";
      Connection connection=DBConnection.getInstance().getConnection();
      PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
           return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public ResultSet getAllSupplierDetails() throws SQLException {
       Connection connection=DBConnection.getInstance().getConnection();
       PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Supplier;");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;

    }
}
