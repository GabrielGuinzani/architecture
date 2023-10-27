package com.satc.architecture.subscription;

import com.satc.architecture.account.AccountEntity;
import com.satc.architecture.exceptions.BehaviorException;
import com.satc.architecture.subscription.behavior.ICancelBehavior;
import com.satc.architecture.subscription.behavior.IChargeBehavior;
import com.satc.architecture.subscription.behavior.ISubscriptionBehavior;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Lazy;

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
    @ManyToOne(fetch = FetchType.LAZY )
    private AccountEntity accountId;
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    private Plan plan;
    private LocalDate subscriptionDate;
    private LocalDate renewData;
    private LocalDate cancelDate;


    public SubscriptionEntity(SubscriptionEntity subscription){
        this.accountId = subscription.getAccountId();
        this.subscriptionStatus = subscription.getSubscriptionStatus();
        this.subscriptionId = subscription.getSubscriptionId();
        this.subscriptionType = subscription.getSubscriptionType();
        this.plan = subscription.getPlan();
        this.subscriptionDate = subscription.getSubscriptionDate();
        this.renewData = subscription.getRenewData();
        this.cancelDate = subscription.getCancelDate();

    }
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
