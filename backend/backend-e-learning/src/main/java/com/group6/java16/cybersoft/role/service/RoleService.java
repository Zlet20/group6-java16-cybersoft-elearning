package com.group6.java16.cybersoft.role.service;

import javax.validation.Valid;

import com.group6.java16.cybersoft.common.model.PageRequestModel;
import com.group6.java16.cybersoft.common.model.PageResponseModel;
import com.group6.java16.cybersoft.role.dto.RoleDTO;
import com.group6.java16.cybersoft.role.dto.RoleResponseDTO;

public interface RoleService {

	RoleResponseDTO createRole(@Valid RoleDTO dto);

	PageResponseModel<RoleResponseDTO> search(PageRequestModel pageRequestModel);

	RoleResponseDTO update(String id, @Valid RoleDTO dto);

	void deleteById(String id);

}
