package com.ilze.highlight.service;

import com.ilze.highlight.dao.RoleDao;
import com.ilze.highlight.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Autowired
  private RoleDao roleDao;

  public Role createNewRole(Role role){
return roleDao.save(role);
  }
}
