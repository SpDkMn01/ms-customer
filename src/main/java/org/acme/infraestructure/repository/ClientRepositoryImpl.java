package org.acme.infraestructure.repository;

import org.acme.domain.contract.ClientRepository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ClientRepositoryImpl implements ClientRepository {


  @Override
  public String getAllClient() {
    return "hola desde Repository reynaldo";
  }
}
