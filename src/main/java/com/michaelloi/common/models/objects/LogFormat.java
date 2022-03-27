package com.michaelloi.common.models.objects;

import com.michaelloi.common.constants.DateFormats;
import com.michaelloi.common.constants.DefaultValues;
import com.michaelloi.common.models.utilities.DateConversion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogFormat {
    private String event = DefaultValues.emptyString;
    private String uuid = DefaultValues.emptyString;
    private String date = DateConversion.toString(new Date(), DateFormats.iso);
    private String path = DefaultValues.emptyString;
    private String service = DefaultValues.emptyString;
    private Object message = new Object();
    private String exception = DefaultValues.emptyString;
}
