package org.agd.loginapp.repository;

import org.agd.loginapp.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AGD on 12/1/2019.
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {}

