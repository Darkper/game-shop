package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Johny Soto
 */
public interface JpaClientRepository extends JpaRepository<Client, String> {
    @Query(value = "select client_id from rents group by client_id order by count(client_id) desc limit 1", nativeQuery = true)
    String getMoreFrequentClientId();
}
