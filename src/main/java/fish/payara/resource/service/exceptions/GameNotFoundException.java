package fish.payara.resource.service.exceptions;

public class GameNotFoundException extends RuntimeException {
    
    public GameNotFoundException(String message) {
        super(message);
    }
}
