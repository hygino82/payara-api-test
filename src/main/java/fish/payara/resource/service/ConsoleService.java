package fish.payara.resource.service;

import java.util.List;
import java.util.Optional;

import fish.payara.resource.dto.ResponseConsoleDTO;
import fish.payara.resource.model.Console;
import fish.payara.resource.repository.IConsoleRepository;
import fish.payara.resource.service.exceptions.ConsoleNotFoundException;
import jakarta.inject.Inject;

public class ConsoleService {

    private final IConsoleRepository consoleRepository;

    @Inject
    public ConsoleService(IConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    public List<ResponseConsoleDTO> findAllConsoles() {
        return consoleRepository.findAllConsoles().stream().map(ResponseConsoleDTO::new).toList();
    }

    public ResponseConsoleDTO findConsoleById(long id) {
         Optional<Console> res = consoleRepository.findById(id);

        if (res.isEmpty()) {
            throw new ConsoleNotFoundException("Não existe Console com o id: " + id);
        }

        return new ResponseConsoleDTO(res.get());
    }
}
