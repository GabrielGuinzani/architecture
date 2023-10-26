package com.satc.architecture.subscription;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Plan {

    MONTHLY(30),
    ANNUALLY(365);
    private Integer days;

}
