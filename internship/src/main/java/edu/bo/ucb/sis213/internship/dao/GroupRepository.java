package edu.bo.ucb.sis213.internship.dao;

import edu.bo.ucb.sis213.internship.entity.RoGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<RoGroup,Integer> {
    public RoGroup findByGroupName(String groupName);
}
