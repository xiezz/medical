package com.xie.work.controller;

import com.xie.work.domain.UserEntity;
import com.xie.work.service.IArticleService;
import com.xie.work.service.ICommentService;
import com.xie.work.service.ILoginService;
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
@RequestMapping("/article")
public class ArticleCtrl {
    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICommentService commentService;

    @RequestMapping(value="/getDiscuss",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDiscuss(HttpServletRequest request){
        Map<String,Object> returnMap = new HashMap<String,Object>();

        try {
            Map<String,Object> map = articleService.findDiscuss();
            //获取user实体
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

    @RequestMapping(value="/getTeam",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getTeam(HttpServletRequest request){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {
            Map<String,Object> map = articleService.findTeam();
            //获取user实体
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
    @RequestMapping(value="/getComment",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getComment(HttpServletRequest request,Long aid){
        Map<String,Object> returnMap = new HashMap<String,Object>();

        try {
            Map<String,Object> map = commentService.findComment(aid);
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

    @RequestMapping(value="/getOneDiscuss",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getOneDiscuss(HttpServletRequest request,Long aid){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {
            Map<String,Object> map = articleService.findOneDiscuss(aid);


            //获取user实体
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

    @RequestMapping(value="/createDiscuss",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> createDiscuss(HttpServletRequest request,String title, String content,Long user_id){
        Map<String,Object> returnMap = new HashMap<String,Object>();

        try {
            Map<String,Object> map = articleService.createDiscuss(title,content,user_id);
            //获取user实体
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

    @RequestMapping(value="/createComment",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> createComment(HttpServletRequest request,String content,Long user_id,Long article_id ){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {
            Map<String,Object> map = commentService.createComment( content, user_id,article_id);
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
    @RequestMapping(value="/createTeam",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> createTeam(HttpServletRequest request,String title, String content,Long user_id ){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        try {
            Map<String,Object> map = articleService.createDiscuss(title,content, user_id);
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