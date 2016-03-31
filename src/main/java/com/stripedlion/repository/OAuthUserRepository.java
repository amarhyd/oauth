package com.stripedlion.repository;

import com.stripedlion.domain.OAuthUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by drewsmith on 3/30/16.
 */
public interface OAuthUserRepository extends CrudRepository<OAuthUser, String> {

    OAuthUser findByClientId(String clientId);

}
