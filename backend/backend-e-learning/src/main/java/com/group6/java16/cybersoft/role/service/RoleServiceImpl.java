package com.group6.java16.cybersoft.role.service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.group6.java16.cybersoft.common.model.PageRequestModel;
import com.group6.java16.cybersoft.common.model.PageResponseModel;
import com.group6.java16.cybersoft.common.util.ServiceHelper;
import com.group6.java16.cybersoft.role.dto.RoleDTO;
import com.group6.java16.cybersoft.role.dto.RoleResponseDTO;
import com.group6.java16.cybersoft.role.mapper.RoleMapper;
import com.group6.java16.cybersoft.role.model.ELRole;
import com.group6.java16.cybersoft.role.repository.ELRoleRepository;




@Service
@PropertySources({ @PropertySource("classpath:/validation/message.properties") })
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private ELRoleRepository roleRepository;
	
	@Autowired
	private ServiceHelper<ELRole> roleServiceHelper;

	@Value("${role.findById.idnotfound}")
	private String messagesRoleIdNotFound;
	
	
	
	@Override
	public RoleResponseDTO createRole(@Valid RoleDTO dto) {
		
		return RoleMapper.INSTANCE.toResponseDTO(roleRepository.save(RoleMapper.INSTANCE.toModel(dto)));
	}

	
	@Override
	public PageResponseModel<RoleResponseDTO> search(PageRequestModel pageRequestModel) {
		int page = pageRequestModel.getPageCurrent()-1;
        int size = pageRequestModel.getItemPerPage();
        boolean isAscending = pageRequestModel.isIncrementSort();
        String fieldNameSearch = pageRequestModel.getFieldNameSearch();
        String fieldNameSort = pageRequestModel.getFieldNameSort();
        String valueSearch = pageRequestModel.getValueSearch();
        Pageable pageable = PageRequest.of(page, size);
        Page<ELRole> rp = null;
        
        if (null != fieldNameSort && fieldNameSort.matches("name|createdBy|createdAt")) {
            pageable = PageRequest.of(page, size,
                    isAscending ? Sort.by(fieldNameSort).ascending() : Sort.by(fieldNameSort).descending());
        }

        if("name".equals(fieldNameSearch)){
            rp =  roleRepository.searchByName(valueSearch, pageable);
        }

        if(rp == null){
            rp = roleRepository.findAll(pageable);
        }

        return new PageResponseModel<>(rp.getNumber() + 1, rp.getTotalPages(), 
            rp.getContent().stream().map(RoleMapper.INSTANCE::toResponseDTO).collect(Collectors.toList()));
    
		
	}


	@Override
	public RoleResponseDTO update(String id, @Valid RoleDTO dto) {
		Optional<ELRole> roleOpt = roleRepository.findById(UUID.fromString(id));
		if(roleOpt.isEmpty()) {
			return null;
		}
		ELRole roleCurrent = roleOpt.get();
		if(!roleCurrent.getName().equals(dto.getName())){
			
			if(roleRepository.findByName(dto.getName()).isEmpty()){
				
				roleCurrent.setName(dto.getName());
			}
			
				roleCurrent.setDescription(dto.getDescription());
			}
		return RoleMapper.INSTANCE.toResponseDTO(roleRepository.save(roleCurrent));
		
	}


	@Override
	public void deleteById(String id) {
		ELRole role = roleServiceHelper.getEntityById(id, roleRepository, messagesRoleIdNotFound);
		roleRepository.delete(role);
		
	}

}
