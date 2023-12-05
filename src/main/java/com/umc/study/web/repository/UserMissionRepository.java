package com.umc.study.web.repository;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.mapping.UserMissions;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMissions, Long> {
    List<UserMissions> findByMemberAndMission(Member member, Mission mission);
}
