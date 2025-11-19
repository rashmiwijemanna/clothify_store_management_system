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
    public void delete(String id) {

    }

    @Override
    public String getLastSupplierId() {
        return "";
    }

    @Override
    public ResultSet getAllSupplierDetails() throws SQLException {
       Connection connection=DBConnection.getInstance().getConnection();
       PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Supplier;");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;

    }
}
