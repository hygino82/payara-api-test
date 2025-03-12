package fish.payara.resource.repository;

import java.util.List;
import java.util.Optional;

import fish.payara.resource.model.Console;

public interface IConsoleRepository {

    List<Console> findAllConsoles();

    Optional<Console> findById(long id);

}
