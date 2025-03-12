package fish.payara.resource.controller;

import java.util.List;

import fish.payara.resource.dto.ResponseConsoleDTO;
import fish.payara.resource.service.ConsoleService;
import fish.payara.resource.service.exceptions.ConsoleNotFoundException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("console")
public class ConsoleController {
    private final ConsoleService service;

    @Inject
    public ConsoleController(ConsoleService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConsoleList() {
        final List<ResponseConsoleDTO> response = service.findAllConsoles();
        return Response
                .ok(response)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findConsoleById(@PathParam("id") long id) {
        try {
            final ResponseConsoleDTO response = service.findConsoleById(id);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (ConsoleNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }

}
