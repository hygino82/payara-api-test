package fish.payara.resource.controller;

import java.util.List;

import fish.payara.resource.dto.RequestGameDTO;
import fish.payara.resource.dto.ResponseGameDTO;
import fish.payara.resource.service.GameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("game")
public class GameController {

    private final GameService service;

    @Inject
    public GameController(GameService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGamelist() {
        final List<ResponseGameDTO> res = service.getGamelist();

        return Response.ok(res).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertGame(RequestGameDTO dto) {
        final ResponseGameDTO res = service.insertGame(dto);

        return Response.status(Response.Status.CREATED).entity(res).build();
    }
}
