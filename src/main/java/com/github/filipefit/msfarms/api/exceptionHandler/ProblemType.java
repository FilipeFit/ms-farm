package com.github.filipefit.msfarms.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    BUSINESS_ERROR("/business_error", "Business error"),
    RESOURCE_NOT_FOUND("Resource_not_found","Resource not found"),
    INVALID_DATA("invalid_data","Invalid Data");

    private String title;
    private String uri;

    ProblemType(String title, String uri) {
        this.title = title;
        this.uri = uri;
    }
}
