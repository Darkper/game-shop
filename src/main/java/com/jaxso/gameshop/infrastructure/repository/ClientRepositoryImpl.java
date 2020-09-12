package com.jaxso.gameshop.infrastructure.repository;

import com.jaxso.gameshop.core.client.Client;
import com.jaxso.gameshop.core.client.ClientRepository;
import com.jaxso.gameshop.infrastructure.jpa.JpaClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JpaClientRepository jpaClientRepository;

    public ClientRepositoryImpl(JpaClientRepository jpaClientRepository) {
        this.jpaClientRepository = jpaClientRepository;
    }

    @Override
    public void save(Client client) {
        jpaClientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(String id) {
        return jpaClientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return jpaClientRepository.findAll();
    }

    @Override
    public void remove(Client client) {
        jpaClientRepository.delete(client);
    }

    @Override
    public String getMoreFrequentClientId() {
        return jpaClientRepository.getMoreFrequentClientId();
    }
}
