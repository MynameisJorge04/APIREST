package com.apirest.app.pdi.Repository;

import com.apirest.app.pdi.Model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Genero, Long> {
}
