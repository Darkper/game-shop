package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johny Soto
 */
public interface JpaClientRepository extends JpaRepository<Client, String> {
}
