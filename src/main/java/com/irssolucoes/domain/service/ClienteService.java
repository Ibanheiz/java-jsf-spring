package com.irssolucoes.domain.service;

import com.irssolucoes.domain.entity.Cliente;
import com.irssolucoes.domain.repository.ClienteRepository;
import com.irssolucoes.infrastructure.persistence.ClienteDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolas Ibanheiz
 */
@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;
    
    public List<Cliente> listAll() {
        return repository.listAll();
    }

    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    public void update(Cliente cliente) {
        repository.update(cliente);
    }

    public void delete(Object obj, int id) {
        repository.delete(obj, id);
    }

    public ClienteRepository getRepository() {
        return repository;
    }
}
