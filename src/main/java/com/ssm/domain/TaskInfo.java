package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class TaskInfo implements Serializable {
    private int id;
    private String taskName;
    private String assiginee;
    private Date createTime;

    public TaskInfo() {
    }

    public TaskInfo(String taskName, String assiginee, Date createTime) {
        this.taskName = taskName;
        this.assiginee = assiginee;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssiginee() {
        return assiginee;
    }

    public void setAssiginee(String assiginee) {
        this.assiginee = assiginee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", assiginee='" + assiginee + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
