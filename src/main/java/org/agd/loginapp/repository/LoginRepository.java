package org.agd.loginapp.repository;

import org.agd.loginapp.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by AGD on 12/1/2019.
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    @Query(
            value = "SELECT DISTINCT(DATE(a.login_time)) FROM login a ORDER BY DATE(a.login_time) ASC",
            nativeQuery = true
    )
    List<Date> getDates();

    @Query(
            value = "SELECT user FROM login a where (:startDate is null or DATE(a.login_time) >= :startDate) " +
                    "and (:endDate is null or DATE(a.login_time) <= :endDate) GROUP BY user",
            nativeQuery = true
    )
    List<String> getUsers(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(
            value = "SELECT a.user as username, COUNT(a.user) as logins FROM login a where " +
                    "(:startDate is null or DATE(a.login_time) >= :startDate) " +
                    "and (:endDate is null or DATE(a.login_time) <= :endDate) " +
                    "and (:user = (' ') or a.user IN :user) " +
                    "and (:firstName = (' ') or a.first_name IN :firstName) " +
                    "and (:middleName = (' ') or a.middle_name IN :middleName) " +
                    "and (:lastName = (' ') or a.last_name IN :lastName) " +
                    "and (:emailAddress = (' ') or a.email_address IN :emailAddress) " +
                    "GROUP BY a.user " +
                    "ORDER BY username",
            nativeQuery = true
    )
    List<Map<String, Integer>> getLogins(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
                  @Param("user") List<String> user, @Param("firstName") List<String> firstName, @Param("middleName") List<String> middleName,
                  @Param("lastName") List<String> lastName, @Param("emailAddress") List<String> emailAddress);


    @Query(
            value = "SELECT * FROM login a where :user = (' ') or a.user IN :user",
            nativeQuery = true
    )
    List<Login> getLoginsTest(@Param("user") List<String> user);
}

