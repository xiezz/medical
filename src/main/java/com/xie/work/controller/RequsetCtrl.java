package com.xie.work.controller;

import com.xie.work.dao.IRequestDao;
import com.xie.work.service.IRequestService;
import com.xie.work.service.ITeamService;
import com.xie.work.service.ITeamUserService;
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
@RequestMapping("/request")
public class RequsetCtrl {
    @Autowired
    private IRequestService requestService;


    @RequestMapping(value="/createRequest",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> createRequest(HttpServletRequest request,Long teamId, Long userId, String content) {
        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {
            content = new String(content.getBytes("8859_1"), "utf8");
            Map<String,Object> map = requestService.createRequest(teamId, userId,content);
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

    @RequestMapping(value = "/findRequest", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findRequest(HttpServletRequest request, Long teamId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();

        try {
            Map<String, Object> map = requestService.findRequest(teamId);
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