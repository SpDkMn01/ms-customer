package com.quarkus.bootcamp.nttdata.infraestructure.repository;

import com.quarkus.bootcamp.nttdata.domain.entity.StateEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StateRepositoryImpl implements PanacheRepository<StateEntity> {

  public StateEntity findByName(String name){
    return find("name", name).firstResult();
  }
}
