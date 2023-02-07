package org.acme;

import org.acme.btask.interfaces.ClientService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/clients")
public class ExampleResource {
    private final ClientService clientService;

    public ExampleResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return clientService.getAllClient();
    }
}