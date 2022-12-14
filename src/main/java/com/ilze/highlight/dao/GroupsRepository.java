package com.ilze.highlight.dao;
import com.ilze.highlight.entity.Groups;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

//@CrossOrigin("http://localhost:4200")
//@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
@Repository
public interface GroupsRepository extends CrudRepository<Groups, Long> {

  Optional<Groups> findByGroupName(String groupName);

  Page<Groups> findByOpen(@RequestParam("open") boolean open, Pageable pageable);

  Page<Groups> findByGroupNameContaining(@RequestParam("group_name") String group_name, Pageable pageable);

//Page <Groups> findByClosedAndStrict(@RequestParam ("closed", "strict") boolean closed, boolean strict, Pageable pageable);


}
