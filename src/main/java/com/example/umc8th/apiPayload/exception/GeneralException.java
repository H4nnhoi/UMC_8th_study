package com.example.umc8th.apiPayload.exception;

import com.example.umc8th.apiPayload.code.BaseErrorCode;
import com.example.umc8th.apiPayload.code.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReason getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReason getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
