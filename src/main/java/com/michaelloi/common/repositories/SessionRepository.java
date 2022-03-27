package com.michaelloi.common.repositories;

import com.michaelloi.common.constants.ParameterValues;
import com.michaelloi.common.constants.QueryValues;
import com.michaelloi.common.models.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<UserData, String> {
    @Query(value = QueryValues.getSessionId, nativeQuery = true)
    String getSessionIdData(
        @Param(ParameterValues.username) String username
    );
}
