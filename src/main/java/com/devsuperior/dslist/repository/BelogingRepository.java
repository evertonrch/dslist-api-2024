package com.devsuperior.dslist.repository;

import com.devsuperior.dslist.entity.Belonging;
import com.devsuperior.dslist.entity.BelongingPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BelogingRepository extends JpaRepository<Belonging, BelongingPK> {

    boolean existsByPosition(Integer position);
}
