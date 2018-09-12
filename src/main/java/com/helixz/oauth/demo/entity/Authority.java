package com.helixz.oauth.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * 
 * @author Chamith
 *
 */
@Getter
@Setter
@Entity
@Table(catalog = "oauth_demo", name = "authority")
public class Authority implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String code;

	public Authority(String code) {
		this.code = code;
	}

	public Authority() {

	}

	@Override
	public String getAuthority() {
		return code;
	}

}
