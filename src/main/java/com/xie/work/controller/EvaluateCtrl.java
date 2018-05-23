package com.xie.work.controller;

import com.xie.work.service.IEvaluateService;
import com.xie.work.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */

@Controller
@RequestMapping("/evaluate")
public class EvaluateCtrl {
    @Autowired
    private IEvaluateService evaluateService;


    @RequestMapping(value="/createEvaluate",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> createEvaluate(HttpServletRequest request,Long teamId, Long userId, Long mateId, Long score, String reason) {
        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {
            reason = new String(reason.getBytes("8859_1"), "utf8");
            Map<String,Object> map = evaluateService.createEvaluate(teamId,userId,mateId,score,reason);
            Object object = map.get("value");
            returnMap.put("value", object);
            returnMap.put("message", map.get("message"));
            returnMap.put("success", map.get("success"));
        } catch (Exception e) {
            returnMap.put("message", "异常：失败!");
            returnMap.put("success", false);
            e.printStackTrace();
        }
        return returnMap;
    }

    @RequestMapping(value = "/findEvaluate", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findEvaluate(HttpServletRequest request, Long mateId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();

        try {
            Map<String, Object> map = evaluateService.findEvaluate(mateId);
            Object object = map.get("value");
            returnMap.put("value", object);
            returnMap.put("message", map.get("message"));
            returnMap.put("success", map.get("success"));
        } catch (Exception e) {
            returnMap.put("message", "异常：失败!");
            returnMap.put("success", false);
            e.printStackTrace();
        }
        return returnMap;
    }
}