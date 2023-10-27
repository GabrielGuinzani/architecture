package com.satc.architecture.subscription;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface SubscriptionRepresentation {
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    class CreateSubscription{
        @NotNull
        @NotEmpty
        @Min(value = 1)
        private Long idAccount;
        @NotNull
        private Plan plan;
        @NotNull
        private SubscriptionType subscriptionType;

    }

}
