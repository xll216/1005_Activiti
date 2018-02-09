package com.ssm.controller;

import com.ssm.domain.TaskInfo;
import com.ssm.service.UserService;
import com.ssm.util.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
public class MainController {
    @Resource
    private UserService userService;

    @RequestMapping(value = {"", "/", "/home"})
    public String index() {
        return "home";
    }


    @RequestMapping("/requestAllTask")
    @ResponseBody
    public BaseResult<TaskInfo> requestAllTask() {

        BaseResult<TaskInfo> result = new BaseResult<>();

        List<TaskInfo> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TaskInfo task = new TaskInfo();
            task.setId(i);
            task.setTaskName("任务--" + i);
            task.setAssiginee("作者--" + i);
            task.setCreateTime(new Date());
            datas.add(task);
        }

        result.setData(datas);
        result.setTotal(datas.size());

        return result;
    }

    @RequestMapping(value = "/submitData")
    public String submitData(String data) {
        System.out.println(data);
        return "index";
    }

}
