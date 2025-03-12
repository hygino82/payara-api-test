package fish.payara.resource.controller;

import fish.payara.resource.repository.GameRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("game")
public class GameController {
    private final GameRepository repository;

    @Inject
    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGamelist() {
        final var res = repository.getGamelist();

        return Response.ok(res).build();
    }
}
