package fish.payara.resource.controller;

import java.util.List;

import fish.payara.resource.dto.ResponseConsoleDTO;
import fish.payara.resource.service.ConsoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
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

}
