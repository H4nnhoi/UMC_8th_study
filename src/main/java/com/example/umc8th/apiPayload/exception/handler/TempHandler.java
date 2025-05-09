package com.example.umc8th.apiPayload.exception.handler;

import com.example.umc8th.apiPayload.code.BaseErrorCode;
import com.example.umc8th.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
