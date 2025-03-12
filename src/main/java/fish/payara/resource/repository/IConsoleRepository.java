package fish.payara.resource.repository;

import java.util.List;

import fish.payara.resource.model.Console;

public interface IConsoleRepository {

    List<Console> findAllConsoles();

}
