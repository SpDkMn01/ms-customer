package com.quarkus.infraestructure.jpapostgres;

import com.quarkus.infraestructure.entity.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ClientRepositoryPostgresJPA extends PanacheRepository<Client> {

}
