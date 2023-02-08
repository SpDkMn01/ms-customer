package com.quarkus.domain.contract;

import com.quarkus.domain.models.ClientDto;
import com.quarkus.infraestructure.entity.Client;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
  List<Client> getAllClient();

  Client addClient(ClientDto clientDto);

  Client updateClientById(Long id,ClientDto clientDto);
  Optional<Client> deleteClientById(Long id);
}
