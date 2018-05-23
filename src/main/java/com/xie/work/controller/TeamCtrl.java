package com.xie.work.controller;

import com.xie.work.service.ITeamService;
import com.xie.work.service.ITeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */

@Controller
@RequestMapping("/team")
public class TeamCtrl {
    @Autowired
    private ITeamUserService teamUserService;
    @Autowired
    private ITeamService teamService;



    @RequestMapping(value="/createTeam",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> createTeam(HttpServletRequest request,String teamName,Integer num, String slogan,Long team_id,Long user_id) {
        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {
            teamName = new String(teamName.getBytes("8859_1"), "utf8");
            slogan = new String(slogan.getBytes("8859_1"), "utf8");
            Map<String,Object> map = teamService.createTeam(team_id,teamName, num,slogan);
            Map<String,Object> mapuser = teamUserService.createTeamUser(team_id,user_id, 1,"队长",teamName);
            Object object = map.get("value");
            Object objectuser = mapuser.get("value");
            returnMap.put("value", object);
            returnMap.put("value", objectuser);
            returnMap.put("message", map.get("message"));
            returnMap.put("success", map.get("success"));
        } catch (Exception e) {
            returnMap.put("message", "异常：失败!");
            returnMap.put("success", false);
            e.printStackTrace();
        }
        return returnMap;
    }


    @RequestMapping(value = "/getUserTeam", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserTeam(HttpServletRequest request, Long userId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();

        try {
            Map<String, Object> map = teamUserService.findTeamUser(userId);
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
    @RequestMapping(value = "/getTeamUser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTeamUser(HttpServletRequest request, Long teamId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();

        try {
            Map<String, Object> map = teamUserService.findUserTeam(teamId);
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

    @RequestMapping(value = "/findOneTeam", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findOneTeam(HttpServletRequest request, Long teamId) {
        Map<String, Object> returnMap = new HashMap<String, Object>();

        try {
            Map<String, Object> map = teamService.findOneTeam(teamId);
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