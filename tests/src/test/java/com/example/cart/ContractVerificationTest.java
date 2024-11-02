package com.example.cart;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junitsupport.IgnoreNoPactsToVerify;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.VerificationReports;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@com.example.hexagonal.architecture.ComponentTest
@Provider("cart-service")
@PactBroker(enablePendingPacts = "true", providerTags = "master")
@IgnoreNoPactsToVerify
@VerificationReports(value = {"console", "json"}, reportDir = "target/pact/reports")
class ContractVerificationTest {

    @BeforeEach
    void before(@Nullable PactVerificationContext context,
                @Autowired(required = false) List<StateHandler> stateHandlers,
                @Value("${embedded.service.port}") int port) {

        if (context != null && stateHandlers != null) {
            context.withStateChangeHandlers(stateHandlers.toArray())
                    .setTarget(new HttpTestTarget("localhost", port, "/"));
        }
    }

    @TestTemplate
    @ExtendWith(PactVerificationSpringProvider.class)
    void verification(@Nullable PactVerificationContext context) {
        if (context != null) {
            context.verifyInteraction();
        }
    }
}
