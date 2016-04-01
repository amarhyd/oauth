package com.stripedlion.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author amar
 *
 */
@Entity
@Table(name = "oauth_access_tokens", schema = "tufono_dev")
public class OAuthToken {

	@Id
	private String id;
	
	@Column(name="expire_time")
	private Date expireTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	

}
