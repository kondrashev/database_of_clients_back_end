package net.ukr.kondrashev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/add/client")
    public Client addClient(@RequestBody Client client) {
        clientRepository.save(new Client(client.getFirstName(), client.getSurName(), client.getPhone()));
        return new Client();
    }

    @PostMapping("/delete/client")
    public Client deleteClient(@RequestBody String listId) {
        ArrayList<Long> IdList = new ArrayList<>();
        for (String box : listId.substring(1, listId.length() - 1).split(",")) {
            IdList.add(Long.parseLong(box));
        }
        for (long id : IdList)
            clientRepository.deleteById(id);
        return new Client();
    }

    @GetMapping("/load/clients")
    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/search/clients")
    public List<Client> searchClients(@RequestParam String surName) {
        return clientRepository.findByClientsSurName(surName);
    }
}
