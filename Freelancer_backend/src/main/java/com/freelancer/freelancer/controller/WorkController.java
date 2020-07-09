package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.constant.Constant;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.entity.Work;
import com.freelancer.freelancer.service.WorkService;
import com.freelancer.freelancer.utils.msgutils.Msg;
import com.freelancer.freelancer.utils.msgutils.MsgCode;
import com.freelancer.freelancer.utils.msgutils.MsgUtil;
import com.freelancer.freelancer.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


@RestController
public class WorkController {
    @RequestMapping("/postProject")
    public void addProject(@RequestBody Map<String, String> params) {
        String name = params.get("title");
        Double paymentLower = Double.parseDouble(params.get("paymentLower"));
        Double paymentHigher = Double.parseDouble(params.get("paymentHigher"));
        String description = params.get("description");

    }
}