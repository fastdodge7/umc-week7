package com.umc.study.web.repository;

import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}
