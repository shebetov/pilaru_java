package com.boots.controller;

import com.boots.entity.Project;
import com.boots.entity.ProjectMember;
import com.boots.entity.ProjectRole;
import com.boots.entity.User;
import com.boots.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class CreateProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMemberRepository projectMemberRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRoleRepository projectRoleRepository;

    @GetMapping("/create_project")
    public String registration(Model model) {
        return "projects/create_project";
    }

    @PostMapping("/create_project")
    public String addUser(@ModelAttribute("projectForm") @Valid Project projectForm, BindingResult bindingResult, Principal principal, Model model) {

        if (bindingResult.hasErrors()) {
            return "projects/create_project";
        }

        projectForm.setCreated_date(0);
        projectRepository.save(projectForm);

        User user = userRepository.findByUsername(principal.getName());
        ProjectRole role = projectRoleRepository.findById(1L).get();
        ProjectMember pm = new ProjectMember();
        pm.setUser(user);
        pm.setProject(projectForm);
        pm.setCreated_date(0);
        pm.setLink_key("WrwH593J3KJJTEJ");
        pm.setRole(role);
        projectMemberRepository.save(pm);
        return "redirect:/";
    }

}
