package com.michaelloi.common.models.objects;

import com.michaelloi.common.constants.DefaultValues;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    private String userId = DefaultValues.emptyString;
    private String userName = DefaultValues.emptyString;
    private String password = DefaultValues.emptyString;
    private String nickName = DefaultValues.emptyString;
    private String fullName = DefaultValues.emptyString;
    private String accountNo = DefaultValues.emptyString;
    private String accountCcy = DefaultValues.emptyString;
    private BigDecimal accountBalance = BigDecimal.ZERO;
}
