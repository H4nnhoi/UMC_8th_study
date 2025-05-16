package com.example.umc8th.apiPayload.exception.handler;

import com.example.umc8th.apiPayload.code.BaseErrorCode;
import com.example.umc8th.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
