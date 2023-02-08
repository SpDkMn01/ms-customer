package com.quarkus.btask.services;
import com.quarkus.domain.models.ClientDto;
import com.quarkus.infraestructure.entity.Client;
import com.quarkus.btask.interfaces.ClientService;
import com.quarkus.domain.contract.ClientRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientServiceImpl implements ClientService {
  private final ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public List<Client> getAllClient() {
    return clientRepository.getAllClient();
  }

  @Override
  @Transactional
  public Client addClient(ClientDto clientDto) {
    return clientRepository.addClient(clientDto);
  }

  @Override
  @Transactional
  public Client updateClientById(Long id, ClientDto clientDto) {
    return clientRepository.updateClientById(id, clientDto);
  }

  @Override
  @Transactional
  public Optional<Client> deleteClientById(Long id) {
    return clientRepository.deleteClientById(id);
  }
}
