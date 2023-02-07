package com.quarkus.bootcamp.nttdata;

import com.quarkus.bootcamp.nttdata.domain.entity.StateEntity;
import com.quarkus.bootcamp.nttdata.infraestructure.repository.StateRepositoryImpl;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;

@Path("states")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class StateResource {
  private static final Logger LOGGER = Logger.getLogger(StateResource.class.getName());

  @Inject
  StateRepositoryImpl repository;

  @GET
  @Transactional
  public List<StateEntity> get() {
    return repository.listAll(Sort.by("name"));
  }

  @GET
  @Path("{id}")
  public StateEntity getSingle(Long id) {
    StateEntity entity = repository.findById(id);
    if (entity == null) {
      throw new WebApplicationException("State with id of " + id + " does not exist.", 404);
    }
    return entity;
  }

  @POST
  @Transactional
  public Response create(StateEntity stateEntity) {
    if (stateEntity.getId() != null) {
      throw new WebApplicationException("Id was invalidly set on request.", 422);
    }
    repository.persist(stateEntity);
    return Response.ok(stateEntity).status(201).build();
  }
  @PUT
  @Path("{id}")
  @Transactional
  public StateEntity update(Long id, StateEntity stateEntity) {
    StateEntity entity = repository.findById(id);
    if (entity == null) {
      throw new WebApplicationException("Car with id of " + id + " does not exist.", 404);
    }
    entity.setName(stateEntity.getName());
    return entity;
  }
  @DELETE
  @Path("{id}")
  @Transactional
  public Response delete(Long id) {
    StateEntity entity = repository.findById(id);
    if (entity == null) {
      throw new WebApplicationException("Car with id of " + id + " does not exist.", 404);
    }
    repository.delete(entity);
    return Response.status(204).build();
  }
}
