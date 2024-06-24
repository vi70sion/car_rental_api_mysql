package com.example.myapi.demo.controller;

import com.example.myapi.demo.model.Client;
import com.example.myapi.demo.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/clients")
public class ClientController {

    ClientService clientService = new ClientService();
    public ClientController() throws SQLException {
    }

    @GetMapping
    public List<Client> getAllClients () throws SQLException {
        return clientService.getAllClientsList();
    }

    @GetMapping("/{id}")
    public Client getCLientById(@PathVariable int id) throws SQLException {
        return clientService.getCLientById(id);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) throws SQLException {
        clientService.addClient(client);
        return client;
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody Client client) throws SQLException {
        clientService.updateClient(id, client);
        return client;
    }
    @DeleteMapping("/{id}")
    public boolean deleteClient (@PathVariable int id) throws SQLException {
        return clientService.deleteClient(id);
    }
}
