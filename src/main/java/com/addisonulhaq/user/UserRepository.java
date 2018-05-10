package com.addisonulhaq.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported=false)
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String UserName);


}
