package com.example.ppt.service;


import com.example.ppt.Repository.SupportRepository;
import com.example.ppt.exception.ApiException;
import com.example.ppt.model.Support;
import com.example.ppt.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportService {
        private final SupportRepository supportRepository;
        public List<Support> getSupport(){
                return supportRepository.findAll();
        }
        public void addSupport(Support support, User user) {
                support.setUserId(user.getId());
                supportRepository.save(support);
        }

        public List<Support> findBySiteProblem(String SiteProblem){
                List<Support> support=supportRepository.findBySiteProblem(SiteProblem);
                if (support==null){
                        throw new ApiException("wrong Site Problem");

                }
                return support;
        }

        public List<Support> findByMembersProblem(String MembersProblem){
                List<Support> support=supportRepository.findByMembersProblem(MembersProblem);
                if (support==null){
                        throw new ApiException("wrong Members Problem");

                }
                return support;
        }
        public void deleteSupport(Integer id) {
                Support support=supportRepository.getById(id);
                supportRepository.delete(support);
        }



        }
