package com.ilze.highlight.service;


import com.ilze.highlight.repositories.GroupsRepository;
import com.ilze.highlight.entity.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GroupsServiceImpl implements GroupsService{

  @Autowired
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

  @Override
  public List<Groups> getGroupDetails(Long id) {
    if(id != null){
      return groupsRepository.findGroupsById(id);
    }else{
      return groupsRepository.findAll();
    }
  }

  @Override
  public void deleteGroup(Long id) {
    groupsRepository.deleteById(id);
  }


//  @Override
//  public List<Groups> findAllGroups() {
//    return groupsRepository.findAll();
//  }
}
