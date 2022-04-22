package com.group6.java16.cybersoft.common.audit;
import java.util.Optional;

import com.group6.java16.cybersoft.common.util.UserPrincipal;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String>{

    @Override
    public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(UserPrincipal.getUsernameCurrent());
    } 
    
}

