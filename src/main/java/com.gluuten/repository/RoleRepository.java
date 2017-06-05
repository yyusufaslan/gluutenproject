package com.gluuten.repository;

import com.gluuten.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by yusufaslan on 31.05.2017.
 */
public interface RoleRepository extends JpaRepository<Role,Long>{

    List<Role> findAll();

    Role findByName(String name);


}
