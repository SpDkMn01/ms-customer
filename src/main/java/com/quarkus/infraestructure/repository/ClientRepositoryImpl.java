package com.quarkus.infraestructure.repository;

import com.quarkus.domain.contract.ClientRepository;
import com.quarkus.domain.models.ClientDto;
import com.quarkus.infraestructure.entity.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.PreparedQuery;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientRepositoryImpl implements ClientRepository {


  @Override
  public List<Client> getAllClient() {
    return Client.listAll();
  }

  @Override
  @Transactional
  public Client addClient(ClientDto clientDto) {
    Client client = new Client();
    client.setName(clientDto.getName());
    client.persist();
    return client;
  }

  @Override
  @Transactional
  public Client updateClientById(Long id, ClientDto clientDto) {
    Client client = new Client();
    Optional<Client> clientOp = Client.findByIdOptional(id);
    if(clientOp.isEmpty()){
      throw new NullPointerException("client not found");
    }
    client = clientOp.get();
    client.setName(clientDto.getName());
    client.persist();
    return clientOp.get();
  }

  @Override
  @Transactional
  public Optional<Client> deleteClientById(Long id) {
    Optional<Client> clientOp = Client.findByIdOptional(id);
    if(clientOp.isEmpty()){
      throw new NullPointerException("client not found");
    }
    Client client = clientOp.get();
    client.delete();
    return clientOp;
  }
}
