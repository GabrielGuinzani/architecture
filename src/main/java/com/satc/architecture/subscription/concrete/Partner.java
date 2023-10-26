package com.satc.architecture.subscription.concrete;

import com.satc.architecture.subscription.SubscriptionEntity;
import com.satc.architecture.subscription.behavior.IRenewBehavior;

public class Partner extends SubscriptionEntity implements IRenewBehavior {
    @Override
    public void performRenew(){
        this.renewBehavior();
    }
    @Override
    public void renewBehavior(){
        this.performCancel();
    }


}