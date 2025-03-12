package fish.payara.resource.service;

import java.util.List;

import fish.payara.resource.dto.ResponseConsoleDTO;
import fish.payara.resource.repository.IConsoleRepository;
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
}
