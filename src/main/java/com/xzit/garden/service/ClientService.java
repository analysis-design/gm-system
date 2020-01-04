package com.xzit.garden.service;

import com.xzit.garden.bean.entity.Client;

import java.util.List;

/**
 * Created by Xsk on 2020/1/2.
 */
public interface ClientService {
    List<Client> findAll();

    Integer addClient(Client client);

    Client findById(Long id);

    Integer updClient(Client client);

    Integer deleteClient(Long id);
}
