package com.irssolucoes.domain.repository;

import com.irssolucoes.domain.entity.Cliente;
import java.util.List;

/**
 *
 * @author Nicolas Ibanheiz
 */
public interface ClienteRepository extends Repository<Cliente>{
    List<Cliente> listAll();
}
