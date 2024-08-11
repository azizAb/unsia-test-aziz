package com.aziz.unsia.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface KegiatanRepo extends JpaRepository<KegiatanEntity, Long> {

  @Procedure(name = "DashboardData")
  Object getDashboardData();

}
