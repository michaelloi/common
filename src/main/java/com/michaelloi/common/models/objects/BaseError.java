package com.michaelloi.common.models.objects;

import com.michaelloi.common.constants.DefaultValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseError {
    private String errorCode = DefaultValues.emptyString;
    private String errorTitle = DefaultValues.emptyString;
    private String errorDescription = DefaultValues.emptyString;

    public BaseError(String errorCode) {
        this.errorCode = errorCode;
    }
}
