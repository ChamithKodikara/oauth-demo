package com.helixz.oauth.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * 
 * @author Chamith
 *
 */
@Getter
@Setter
@Entity
@Table(catalog = "oauth_demo", name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	@ManyToMany
	@JoinTable(catalog = "oauth_demo", name = "role_authority",
			joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private Set<Authority> authorities;

	@ManyToMany
	@JoinTable(catalog = "oauth_demo", name = "user_role",
			joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	private Set<User> users;

	public Role() {
	}

	public Role(Long id) {
		this.id = id;
	}

}
