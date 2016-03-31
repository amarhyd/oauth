package com.stripedlion.oauth;

import com.stripedlion.domain.OAuthUser;
import com.stripedlion.repository.OAuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by drewsmith on 3/30/16.
 */
//@Component
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private OAuthUserRepository oauthUserRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        OAuthUser user = oauthUserRepository.findById(s);
        if(user == null) {
            throw new ClientRegistrationException("Could not find user for clientId: " + s);
        }
        return new OAuthUserClientDetails(user);
    }

    public static class OAuthUserClientDetails implements ClientDetails {

        private final OAuthUser user;

        public OAuthUserClientDetails(OAuthUser user) {
            this.user = user;
        }

        @Override
        public String getClientId() {
            return user.getId();
        }

        @Override
        public Set<String> getResourceIds() {
            return null;
        }

        @Override
        public boolean isSecretRequired() {
            return false;
        }

        @Override
        public String getClientSecret() {
            return user.getSecret();
        }

        @Override
        public boolean isScoped() {
            return false;
        }

        @Override
        public Set<String> getScope() {
            String[] scopes = new String[]{"read", "write", "trust"};
            return new HashSet<String>(Arrays.asList(scopes));
        }

        @Override
        public Set<String> getAuthorizedGrantTypes() {
            String[] grantTypes = new String[]{"password", "authorization_code", "refresh_token", "implicit"};
            return new HashSet<String>(Arrays.asList(grantTypes));
        }

        @Override
        public Set<String> getRegisteredRedirectUri() {
            return null;
        }

        @Override
        public Collection<GrantedAuthority> getAuthorities() {
            GrantedAuthority authority = new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_CLIENT";
                }
            };
            return Collections.singletonList(authority);
        }

        @Override
        public Integer getAccessTokenValiditySeconds() {
            return 360;
        }

        @Override
        public Integer getRefreshTokenValiditySeconds() {
            return 360;
        }

        @Override
        public boolean isAutoApprove(String s) {
            return false;
        }

        @Override
        public Map<String, Object> getAdditionalInformation() {
            return null;
        }
    }
}
