package com.ilze.highlight.controller;

import com.ilze.highlight.dao.GroupsRepository;
import com.ilze.highlight.entity.Groups;
import com.ilze.highlight.service.GroupsService;
import com.ilze.highlight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/groups") // pre-path
public class GroupsController {

//  @Autowired
//  private GroupsService groupsService;
//
//  public GroupsController(GroupsService groupsService) {
//    this.groupsService = groupsService;
//  }

  @Autowired
  private GroupsService groupsService;

  @Autowired
  private final GroupsRepository groupsRepository;


  public GroupsController(GroupsRepository groupsRepository) {
    this.groupsRepository = groupsRepository;
  }

  @GetMapping("/all-groups")
  public List<Groups> getGroups(){
    return (List<Groups>) groupsRepository.findAll();
  }

  @PostMapping("/save-groups")
  void addGroup(@RequestBody Groups groups){
    groupsRepository.save(groups);
  }
}
