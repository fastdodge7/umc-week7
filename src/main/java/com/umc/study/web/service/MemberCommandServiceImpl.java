package com.umc.study.web.service;

import com.umc.study.domain.Member;
import com.umc.study.web.dto.MemberRequestDTO;
import com.umc.study.web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        return null;
    }
}
