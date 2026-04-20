package com.asdf.buddyboard.service;

import com.asdf.buddyboard.dto.MemberRequestDto;
import com.asdf.buddyboard.dto.MemberResponseDto;
import com.asdf.buddyboard.entity.Member;
import com.asdf.buddyboard.entity.Referral;
import com.asdf.buddyboard.exception.MemberNotFoundException;
import com.asdf.buddyboard.repository.MemberRepository;
import com.asdf.buddyboard.repository.ReferralRepository;
import com.asdf.buddyboard.util.EntityDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final ReferralRepository referralRepository;

    public MemberResponseDto addMember(MemberRequestDto dto){
        // 일단 멤버 추가
        Member member = EntityDtoMapper.toEntity(dto);
        Member savedMember = memberRepository.save(member);

        if(dto.getReferrer()!= null) {
            // 추천인이 존재하는지 먼저 확인.
            Member referrer = memberRepository.findByUsername(dto.getReferrer()).orElseThrow(() -> new MemberNotFoundException("추천인을 찾을 수 없습니다."));
            // 추천 관계 추가
            Referral ref = Referral.builder()
                    .referrer(referrer)
                    .referred(savedMember)
                    .build();
            referralRepository.save(ref);
        }
        return EntityDtoMapper.toDto(savedMember);
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> getMembers(){
        return memberRepository.findAll().stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public MemberResponseDto getMemberById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
        return EntityDtoMapper.toDto(member);
    }

    public MemberResponseDto updateMemberById(Long id, MemberRequestDto dto){
        Member member = memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
        member.setPassword(dto.getPassword());
        member.setEmail(dto.getEmail());
        return EntityDtoMapper.toDto(memberRepository.save(member));
    }

    public void deleteMemberById(Long id){
        memberRepository.deleteById(id);
    }
}
