package com.asdf.buddyboard.service;

import com.asdf.buddyboard.dto.ReferralResponseDto;
import com.asdf.buddyboard.entity.Referral;
import com.asdf.buddyboard.repository.ReferralRepository;
import com.asdf.buddyboard.util.EntityDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ReferralService {
    private final ReferralRepository referralRepository;

    // 특정 추천인 기준으로 조회
    @Transactional(readOnly = true)
    public List<ReferralResponseDto> getReferralsByReferrer(Long id){
        return referralRepository.findByReferrer_id(id).stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }

    // 내가 입력한 추천인 조회
    public ReferralResponseDto getReferralByReferred(Long id){
        Referral ref = referralRepository.findByReferred_id(id).orElseThrow(()-> new RuntimeException(""));
        return EntityDtoMapper.toDto(ref);
    }
}
