package com.chatapp.messageProducer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

@Configuration
public class KeyCloakConfig {

    @Bean
    public ClientRegistrationRepository clientRepository() {

        ClientRegistration keycloak = keycloakClientRegistration();
        return new InMemoryClientRegistrationRepository(keycloak);
    }

    private ClientRegistration keycloakClientRegistration() {

        return ClientRegistration.withRegistrationId("chatApp")
                .clientId("message-producer")
                .clientSecret("lz2COUZ3umaAF97eAnqbiGdhTEjn9InL")
                .redirectUri("http://localhost:8002/login/oauth2/code/chatApp")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .issuerUri("http://keycloak:8080/realms/chatApp")
                .authorizationUri("http://keycloak:8080/realms/chatApp/protocol/openid-connect/auth")
                .tokenUri("http://keycloak:8080/realms/chatApp/protocol/openid-connect/token")
                .userInfoUri("http://keycloak:8080/realms/chatApp/protocol/openid-connect/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .build();
    }
}
