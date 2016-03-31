package com.stripedlion.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by drewsmith on 3/30/16.
 */
@Entity
@Table(name = "oauth_clients", schema = "tufono_dev")
public class OAuthUser {

    @Id
    private String id;

    @Column
    private String secret;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTime;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
