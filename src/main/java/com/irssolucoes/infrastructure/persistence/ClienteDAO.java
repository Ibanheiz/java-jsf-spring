package com.irssolucoes.infrastructure.persistence;

import com.irssolucoes.domain.entity.Cliente;
import com.irssolucoes.domain.repository.ClienteRepository;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nicolas Ibanheiz
 */
@Repository
public class ClienteDAO extends DAO<Cliente> implements ClienteRepository {

    public List<Cliente> listAll() {
        String sql = "SELECT c FROM Cliente c ORDER BY c.id DESC";
        TypedQuery<Cliente> createQuery = getEntityManager().createQuery(sql, Cliente.class);
        List<Cliente> result = createQuery.getResultList();
        return result;

    }
}
