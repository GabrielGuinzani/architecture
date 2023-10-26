package com.satc.architecture.subscription;

import com.satc.architecture.exceptions.BehaviorException;
import com.satc.architecture.subscription.behavior.ICancelBehavior;
import com.satc.architecture.subscription.behavior.IChargeBehavior;
import com.satc.architecture.subscription.behavior.ISubscriptionBehavior;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivilegedAction;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class SubscriptionEntity implements ISubscription, ISubscriptionBehavior, ICancelBehavior, IChargeBehavior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;
    private Boolean subscriptionStatus;
    private Long accountId;
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    private Plan plan;
    private LocalDate subscriptionDate;
    private LocalDate renewData;
    private LocalDate cancelDate;

    @Override
    public void performSubscription(Long idAccount, Plan plan) {
        this.subscriptionBehavior(idAccount, plan);

    }

    @Override
    public void performRenew() {
        throw new BehaviorException("Assinatura do Tipo FREE, não contém renewDate");
    }

    @Override
    public void performCancel() {

    }

    @Override
    public void cancelBehavior(){
        this.cancelDate = LocalDate.now();
    }

    @Override
    public void performCharge() {
        this.chargeBehavior();
    }

    @Override
    public SubscriptionEntity subscriptionBehavior(Long idAccount, Plan plan) {
        return this.subscriptionBehavior(idAccount, plan);

    }

    @Override
    public void chargeBehavior(){
        throw new BehaviorException("Assinatura do Tipo FREE, não contém performCharge");
    }
}
