package com.satc.architecture.subscription.behavior;

import com.satc.architecture.subscription.Plan;
import com.satc.architecture.subscription.SubscriptionEntity;

public interface ISubscriptionBehavior {

    SubscriptionEntity subscriptionBehavior(Long idAccount, Plan plan);

}
