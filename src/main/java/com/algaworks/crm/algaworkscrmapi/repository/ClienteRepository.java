package com.algaworks.crm.algaworkscrmapi.repository;

import com.algaworks.crm.algaworkscrmapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
