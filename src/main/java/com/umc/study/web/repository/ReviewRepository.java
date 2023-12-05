package com.umc.study.web.repository;

import com.umc.study.domain.Member;
import com.umc.study.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
