package me.dio.sacola.repository;

import me.dio.sacola.model.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //interface conecta com o banco de dados
public interface SacolaRepository extends JpaRepository<Sacola, Long> {
}
