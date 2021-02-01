package net.ukr.kondrashev;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c where c.surName = :surName")
    List<Client> findByClientsSurName(@Param("surName") String surName);
}
