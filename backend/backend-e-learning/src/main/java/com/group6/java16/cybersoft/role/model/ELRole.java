package com.group6.java16.cybersoft.role.model;


import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group6.java16.cybersoft.common.model.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "el_role")
public class ELRole extends BaseEntity {
	@Size(min = 5, max = 100)
	private String name;

	@NotBlank
	private String description;
	
	@JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<ELGroup> groups = new LinkedHashSet<ELGroup>();
   


}
