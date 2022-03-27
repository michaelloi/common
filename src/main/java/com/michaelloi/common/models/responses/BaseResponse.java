package com.michaelloi.common.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.michaelloi.common.constants.*;
import com.michaelloi.common.models.objects.BaseError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class BaseResponse<T> {
    private String responseCode;
    private String responseTitle;
    private String responseDescription;
    private String language;
    private T data;

    public BaseResponse(String language) {
        this.language = language;
        this.responseCode = DefaultValues.emptyString;
        this.responseTitle = DefaultValues.emptyString;
        this.responseDescription = DefaultValues.emptyString;
    }

    @JsonIgnore
    public void setResponseSuccess() {
        this.responseCode = ErrorCodes.general.success;
        this.responseTitle = language.equalsIgnoreCase(LanguageValues.enLanguage) ? LabelCodes.success.english : LabelCodes.success.indonesia;
        this.responseDescription = language.equalsIgnoreCase(LanguageValues.enLanguage) ? LabelCodes.success.english : LabelCodes.success.indonesia;
    }

    @JsonIgnore
    public void setResponseError() {
        this.responseCode = ErrorCodes.general.failed;
        this.responseTitle = getResponseTitle(DefaultValues.emptyString);
        this.responseDescription = getResponseDescription(DefaultValues.emptyString);
    }

    @JsonIgnore
    public void setResponseError(BaseError baseError) {
        this.responseCode = baseError.getErrorCode();
        this.responseTitle = getResponseTitle(baseError.getErrorTitle());
        this.responseDescription = getResponseDescription(baseError.getErrorDescription());
    }

    public void setResponseError(BaseResponse baseResponse) {
        this.responseCode = baseResponse.getResponseCode();
        this.responseTitle = getResponseTitle(baseResponse.getResponseTitle());
        this.responseDescription = getResponseDescription(baseResponse.getResponseDescription());
    }

    public void setResponseError(String responseTitle) {
        this.responseCode = ErrorCodes.general.failed;
        this.responseTitle = responseTitle;
        this.responseDescription = DefaultValues.emptyString;
    }

    public void setResponseError(String responseCode, String responseTitle) {
        this.responseCode = responseCode;
        this.responseTitle = responseTitle;
        this.responseDescription = DefaultValues.emptyString;
    }

    @JsonIgnore
    public void setResponse(T response) {
        this.responseCode = ErrorCodes.general.success;
        this.responseTitle = language.equalsIgnoreCase(LanguageValues.enLanguage) ? LabelCodes.success.english : LabelCodes.success.indonesia;
        this.responseDescription = language.equalsIgnoreCase(LanguageValues.enLanguage) ? LabelCodes.success.english : LabelCodes.success.indonesia;
        this.data = response;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return responseCode.equalsIgnoreCase(ErrorCodes.general.success);
    }

    private String getResponseTitle(String responseTitle) {
        if (responseTitle == null) {
            return language.equalsIgnoreCase(LanguageValues.enLanguage)
                ? ErrorMessage.title.english
                : ErrorMessage.title.indonesia;
        }
        if (responseTitle.isEmpty()) {
            return language.equalsIgnoreCase(LanguageValues.enLanguage)
                ? ErrorMessage.title.english
                : ErrorMessage.title.indonesia;
        }

        return responseTitle;
    }

    private String getResponseDescription(String responseDescription) {
        if (responseDescription == null) {
            return language.equalsIgnoreCase(LanguageValues.enLanguage)
                ? ErrorMessage.description.english
                : ErrorMessage.description.indonesia;
        }
        if (responseDescription.isEmpty()) {
            return language.equalsIgnoreCase(LanguageValues.enLanguage)
                ? ErrorMessage.description.english
                : ErrorMessage.description.indonesia;
        }

        return responseDescription;
    }
}
