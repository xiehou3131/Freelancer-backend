package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.entity.UserSkill;
import com.freelancer.freelancer.service.UserSkillService;
import com.freelancer.freelancer.entity.Skill;
import com.freelancer.freelancer.service.SkillService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SkillController {

    @Autowired
    SkillService skillService;

    @Autowired(required = false)
    UserSkillService userSkillService;

    @RequestMapping("/addSkill")
    public void addSkill(@RequestBody Map<String, String> params) {
        String skillName = params.get("skillName");
        Skill duplicate = skillService.checkDuplicate(skillName);

        if (duplicate == null) {
            Skill newSkill = new Skill();
            newSkill.setSkillName(skillName);
            skillService.addSkill(newSkill);

            JSONObject data = JSONObject.fromObject(newSkill);
        }
    }

    @RequestMapping("/userAddSkills")
    public void userAddSkills(@RequestBody Map<String, String> params) {
        UserSkill newUserSkill = new UserSkill();
        // System.out.println(Integer.parseInt(params.get("u_id")));
        // System.out.println(Integer.parseInt(params.get("s_id")));
        newUserSkill.setUId(1);
        newUserSkill.setSId(1);

        userSkillService.addUserSkill(newUserSkill);
    }

    @RequestMapping("/getSkillsByCategory")
    public List<Skill> getSkillsByCategory(@RequestBody Map<String, Integer> params) {
        Integer category = params.get("category");
        return skillService.getSkillsByCategory(category);
    }

}