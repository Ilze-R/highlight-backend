package com.ilze.highlight.dao;

import com.ilze.highlight.entity.Groups;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupsRepository extends JpaRepository<Groups, Long> {

    Page<Groups> findByClosed(@RequestParam("closed") boolean closed, Pageable pageable);

    Page<Groups> findByGroupNameContaining(@RequestParam("group_name") String group_name, Pageable pageable);

//Page <Groups> findByClosedAndStrict(@RequestParam ("closed", "strict") boolean closed, boolean strict, Pageable pageable);

//  LV4798131






}
