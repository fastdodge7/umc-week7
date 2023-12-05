package com.umc.study.web.service;

import com.umc.study.domain.Member;
import com.umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);
}
