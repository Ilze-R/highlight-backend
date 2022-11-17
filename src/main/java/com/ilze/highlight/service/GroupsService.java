package com.ilze.highlight.service;

import com.ilze.highlight.entity.Groups;

import java.util.List;
import java.util.Optional;

public interface GroupsService {

  Groups saveGroup(Groups group);

  Optional<Groups> findByGroupName(String groupName);

//  List<Groups> findAllGroups();
}
