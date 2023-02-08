package com.quarkus.btask.interfaces;

import com.quarkus.domain.models.ClientDto;
import com.quarkus.infraestructure.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
  List<Client> getAllClient();

  Client addClient(ClientDto clientDto);

  Client updateClientById(Long id,ClientDto clientDto);
  Optional<Client> deleteClientById(Long id);
}
