package com.umc.study.web.service;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.apiPayload.exception.handler.TempHandler;
import org.springframework.stereotype.Service;

@Service
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
