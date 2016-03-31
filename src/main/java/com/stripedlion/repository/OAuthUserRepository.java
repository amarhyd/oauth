package com.stripedlion.repository;

import com.stripedlion.domain.OAuthUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by drewsmith on 3/30/16.
 */
@RepositoryRestResource(path = "oauth_users")
public interface OAuthUserRepository extends CrudRepository<OAuthUser, String> {

    OAuthUser findById(String id);

}
