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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


@RestController
public class WorkController {
    @Autowired
    private WorkService workService;
    @RequestMapping("/postWork")
    public void addProject(@RequestBody Map<String, String> params) {
        String name = params.get("title");
        Double paymentLower = Double.parseDouble(params.get("paymentLower"));
        Double paymentHigher = Double.parseDouble(params.get("paymentHigher"));
        String description = params.get("description");

//        Work work = workService.findByTitle(name);
//        if(work == null){
        Work work = new Work();
        work.setTitle(name);
        work.setPaymentLower(paymentLower);
        work.setPaymentHigher(paymentHigher);
        work.setDescription(description);
        workService.save(work);
    }

    @RequestMapping("/getWorks")
    public List<Work> getWorks(@RequestBody Map<String, Integer> params) {
        System.out.println("test");
        Integer PageNum = params.get("pagenum");
        Integer PageContentNum = params.get("size");
        if (PageNum <=0 || PageContentNum <=0) { PageNum = 1; PageContentNum = 20; }

        Pageable pageable = PageRequest.of(PageNum - 1, PageContentNum, Sort.by(Sort.Direction.ASC, "w_id"));
        return workService.getWorks(pageable).getContent();
    }

    @RequestMapping("/getPostedWorks")
    public List<Work> getPostedWorks(@RequestBody Map<String, Integer> params) {
        Integer PageNum = params.get("pagenum");
        Integer PageContentNum = params.get("size");
        Integer uId = params.get("u_id");
        if (PageNum <=0 || PageContentNum <=0) { PageNum = 1; PageContentNum = 20; }

        Pageable pageable = PageRequest.of(PageNum - 1, PageContentNum, Sort.by(Sort.Direction.ASC, "w_id"));

        return workService.getPostedWorks(uId, pageable).getContent();
    }

    @RequestMapping("/getFinishedWorks")
    public List<Work> getFinishedWorks(@RequestBody Map<String, Integer> params) {
//        Integer PageNum = params.get("pagenum");
//        Integer PageContentNum = params.get("size");
        Integer uId = params.get("u_id");
//        if (PageNum <=0 || PageContentNum <=0) { PageNum = 1; PageContentNum = 20; }

        Integer status = 1;
        return workService.getWorkerWorks(uId);
    }
}
