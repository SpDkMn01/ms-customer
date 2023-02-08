package com.quarkus.application.rest;

import com.quarkus.btask.interfaces.ClientService;
import com.quarkus.domain.models.ClientDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.util.List;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Client {
  private final ClientService clientService;

  public Client(ClientService clientService) {
    this.clientService = clientService;
  }


  @GET
  public Response getAllClient() {
    return Response.ok(this.clientService.getAllClient()).build();
  }

  @POST
  public Response addClient(ClientDto clientDto) {
    return Response.ok(this.clientService.addClient(clientDto)).status(201).build();
  }

  @PUT
  @Path("{id}")
  public Response updateClient(@PathParam("id") Long id, ClientDto clientDto) {
    return Response.ok(this.clientService.updateClientById(id, clientDto)).status(204).build();
  }

  @DELETE
  @Path("{id}")
  public Response updateClient(@PathParam("id") Long id) {
    this.clientService.deleteClientById(id);
    return Response.status(204).build();
  }

}
