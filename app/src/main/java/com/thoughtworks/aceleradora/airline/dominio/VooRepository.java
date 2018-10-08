package com.thoughtworks.aceleradora.airline.dominio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VooRepository extends CrudRepository<Voo, Long>, JpaSpecificationExecutor<Voo> {

}
