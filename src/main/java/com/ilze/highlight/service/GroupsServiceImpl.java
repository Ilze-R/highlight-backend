package com.ilze.highlight.service;


import com.ilze.highlight.dao.GroupsRepository;
import com.ilze.highlight.entity.Groups;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GroupsServiceImpl implements GroupsService{

  private final GroupsRepository groupsRepository;

  public GroupsServiceImpl(GroupsRepository groupsRepository) {
    this.groupsRepository = groupsRepository;
  }

  @Override
  public Groups saveGroup(Groups group) {
    group.setCreateTime(LocalDateTime.now());
    return groupsRepository.save(group);
  }

  @Override
  public Optional<Groups> findByGroupName(String groupName) {
    return groupsRepository.findByGroupName(groupName);
  }

//  @Override
//  public List<Groups> findAllGroups() {
//    return groupsRepository.findAll();
//  }
}
