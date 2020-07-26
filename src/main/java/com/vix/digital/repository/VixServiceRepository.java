package com.vix.digital.repository;

import com.vix.digital.model.VixService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VixServiceRepository extends JpaRepository<VixService,Integer> {
    public VixService findByName(String serviceName);
}
