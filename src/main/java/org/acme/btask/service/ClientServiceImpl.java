package org.acme.btask.service;

import org.acme.btask.interfaces.ClientService;
import org.acme.domain.contract.ClientRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientServiceImpl implements ClientService {
  private final ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public String getAllClient() {
    return clientRepository.getAllClient();
  }
}
