package com.thoughtworks.aceleradora.airline.dominio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroportoRepository extends CrudRepository<Aeroporto, Long> {
}
