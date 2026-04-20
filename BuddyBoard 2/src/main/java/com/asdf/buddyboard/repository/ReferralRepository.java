package com.asdf.buddyboard.repository;

import com.asdf.buddyboard.entity.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReferralRepository extends JpaRepository<Referral, Long> {
    List<Referral> findByReferrer_id(Long id);
    Optional<Referral> findByReferred_id(Long id);
}
