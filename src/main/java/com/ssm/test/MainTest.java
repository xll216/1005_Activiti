package com.ssm.test;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath*:spring-*.xml"})
public class MainTest {

    /*采用注解的方式获取activiti中的关键对象*/

    /*1,仓库服务对象*/
    @Resource
    private RepositoryService repositoryService;

    /*2,运行服务对象，针对的是当前正在执行的任务*/
    @Resource
    private RuntimeService runtimeService;

    /*3,表单服务对象*/
    @Resource
    private FormService formService;

    /*4,任务服务对象，流程中的某一个任务，包含任务的信息*/
    @Resource
    private TaskService taskService;

    /*5,历史流程管理*/
    @Resource
    private HistoryService historyService;

    /*6,用户服务对象*/
    @Resource
    private IdentityService identityService;

    /*7,管理服务对象*/
    @Resource
    private ManagementService managementService;

    /**
     * 启动流程
     **/
    @Test
    public void startProcess() {
        /*1,获取某个流程实例 参数对应*.bpmn中的process id*/
        ProcessInstance pi = runtimeService
                .startProcessInstanceByKey(
                        "myProcess");

        System.out.println("流程实例ID：" + pi.getId());

        System.out.println("流程定义ID" + pi.getProcessDefinitionId());

        /*2,查看流程中的任务列表*/
        List<Task> taskList = taskService
                .createTaskQuery()
                /*查询条件*/
                //流程定义id
                .processDefinitionId(
                        pi.getProcessDefinitionId())
                .taskAssignee("张三")//任务办理人
                .list();//返回集合

        /*遍历返回的任务集合*/
        for (Task task : taskList) {
            System.out.println("任务ID：" + task.getId());
            System.out.println("任务名称：" + task.getName());
            System.out.println("任务的创建时间：" + task.getCreateTime());
            System.out.println("******");
        }
    }

    /**
     * 完成某个任务
     **/
    @Test
    public void commitTask() {
        Task task = taskService.createTaskQuery()
                .taskAssignee("张三")
                .singleResult();

        System.out.println(task);

        if (task != null) {
            /*结束任务*/
            taskService.complete(task.getId());
        }


    }
}
