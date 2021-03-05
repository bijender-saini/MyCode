package com.hostbook.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role //extends BaseEntity implements Serializable {
{
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	// @NotBlank
	@Column(unique = true,name = "ROLE_NAME")
	
	private String name;

	// @NotBlank
	@Column(name = "DESCRIPTION")
	private String description;

	public Role() {
		// constructor
	}

	public Role(String name, String description) {
		this.name = name.toUpperCase();
		this.description = description;
	}

}
