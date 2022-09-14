package com.example.ppt.Repository;

import com.example.ppt.model.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportRepository extends JpaRepository<Support,Integer> {

    List<Support> findBySiteProblem(String SiteProblem);

   List<Support> findSupportByUserId(Integer userId);

   List<Support> findByMembersProblem(String MembersProblem);


}
