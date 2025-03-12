package fish.payara.resource.controller;

import java.util.List;

import fish.payara.resource.dto.RequestGameDTO;
import fish.payara.resource.dto.ResponseGameDTO;
import fish.payara.resource.service.GameService;
import fish.payara.resource.service.exceptions.GameNotFoundException;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateGame(@PathParam("id") long id, RequestGameDTO dto) {
        try {
            ResponseGameDTO res = service.updateGame(id, dto);
            return Response.status(Response.Status.OK).entity(res).build();

        } catch (GameNotFoundException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();

        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGameById(@PathParam("id") long id) {
        try {
            final ResponseGameDTO response = service.findGameById(id);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (GameNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removeGameById(@PathParam("id") long id) {
        final boolean res = service.removeGameById(id);

        if (res) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).entity("Jogo não encontrado!").build();
    }
}
