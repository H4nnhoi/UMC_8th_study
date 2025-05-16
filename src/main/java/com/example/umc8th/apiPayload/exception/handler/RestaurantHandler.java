package com.example.umc8th.apiPayload.exception.handler;

import com.example.umc8th.apiPayload.code.BaseErrorCode;
import com.example.umc8th.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {
    public RestaurantHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
