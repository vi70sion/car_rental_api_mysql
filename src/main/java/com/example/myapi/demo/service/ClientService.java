package com.example.myapi.demo.service;
import com.example.myapi.demo.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.example.myapi.demo.Constants.*;

public class ClientService {

    private Connection _connection;
    private List<Client> clientList;
    public ClientService() throws SQLException {
        _connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //carList = new ArrayList<>();
    }

    public List<Client> getAllClientsList() throws SQLException {
        clientList = new ArrayList<>();
        String sql = "SELECT * FROM client";
        PreparedStatement statement = _connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("client_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            clientList.add(new Client(id, firstName, lastName, email, phone));
        }
        return clientList;
    }

    public Client addClient(Client client) throws SQLException {
        String sql = "INSERT INTO client ( first_name, last_name, email, phone) VALUES (?,?,?,?)";
        PreparedStatement statement = _connection.prepareStatement(sql);
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getEmail());
        statement.setString(4, client.getPhone());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) return client;
        else return null;
    }

    public Client getCLientById(int id) throws SQLException {
        String sql = "SELECT * FROM client WHERE client_id = ?";
        PreparedStatement statement = _connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        boolean hasResults = resultSet.next();
        if(!hasResults) return null;
        int client_id = resultSet.getInt("client_id");
        String first_name = resultSet.getString("first_name");
        String last_name = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        return (new Client(client_id, first_name, last_name, email, phone));
    }

    public Client updateClient(int id, Client client) throws SQLException {
        if(getCLientById(id) == null) {
            addClient(client);
            return client;
        }
        client.setId(id);
        String updateSql = "UPDATE client SET first_name = ?, last_name = ?, email = ?, phone = ? WHERE client_id = ?";
        PreparedStatement statement = _connection.prepareStatement(updateSql);
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getEmail());
        statement.setString(4, client.getPhone());
        statement.setInt(5, id);
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) return client;
            else return null;
    }

    public boolean deleteClient(int id) throws SQLException {
        String deleteSql = "DELETE FROM client WHERE client_id = ?";
        PreparedStatement statement = _connection.prepareStatement(deleteSql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        return (rowsDeleted > 0) ? true : false;
    }

}
