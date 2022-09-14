package com.example.ppt.controller;

import com.example.ppt.Dto.ApiResponse;
import com.example.ppt.model.Support;
import com.example.ppt.model.User;
import com.example.ppt.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/support")
@RestController
@RequiredArgsConstructor
public class SupportController {
    private final SupportService supportService;

    @GetMapping
    public ResponseEntity getSupport() {
        return ResponseEntity.status(200).body(supportService.getSupport());
    }

    @PostMapping("/add")
    public ResponseEntity addSupport(@RequestBody @Valid Support support, @AuthenticationPrincipal User user) {
        supportService.addSupport(support,user);
        return ResponseEntity.status(201).body(new ApiResponse("New Support added !", 201));
    }

    @GetMapping("/SiteProblem")
    public ResponseEntity<List<Support>> findBySiteProblem(@RequestParam String SiteProblem){
        List<Support> support=supportService.findBySiteProblem(SiteProblem);
        return ResponseEntity.status(201).body(support);
    }

    @GetMapping("/MembersProblem")
    public ResponseEntity<List<Support>> findByMembersProblem(@RequestParam String MembersProblem){
        List<Support> support=supportService.findByMembersProblem(MembersProblem);
        return ResponseEntity.status(201).body(support);
    }


    @DeleteMapping
    public ResponseEntity deleteSupport(@PathVariable @Valid Integer id){
        supportService.deleteSupport(id);
        return ResponseEntity.status(201).body(new ApiResponse("support deleted",201));

    }

}
