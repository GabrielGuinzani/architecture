package com.satc.architecture.subscription;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
    private SubscriptionService subscriptionService;
    @PostMapping
    @RequestMapping("/create-subscription")
    public ResponseEntity createSubscription(
            @Validated @RequestBody SubscriptionRepresentation.CreateSubscription createSubscription
    ){
        this.subscriptionService.createNewSubscription();
        return ResponseEntity.ok().build();
    };

}
