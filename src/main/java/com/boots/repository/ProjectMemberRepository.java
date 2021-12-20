package com.boots.repository;

import com.boots.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {

    @Query(value="SELECT x FROM ProjectMember x WHERE x.user.id = :userId")
    List<ProjectMember> findByUserId(Long userId);
}
