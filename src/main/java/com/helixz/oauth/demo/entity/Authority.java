package com.helixz.oauth.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Chamith
 *
 */
@Data
@Entity
@Table(catalog = "oauth_demo", name = "authority")
@AllArgsConstructor
@NoArgsConstructor
public class Authority implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String code;

	@Override
	public String getAuthority() {
		return code;
	}

}