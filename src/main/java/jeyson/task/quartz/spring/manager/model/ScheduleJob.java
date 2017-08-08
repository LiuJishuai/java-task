package jeyson.task.quartz.spring.manager.model;

import java.io.Serializable;

/**
 * Created by  liujishuai
 * Create Date: 2017/8/8 17:45
 * Description:
 */
public class ScheduleJob implements Serializable {

    /**
     * id
     */
    private String jobId;

    /**
     * name
     */
    private String jobName;

    /**
     * 分组
     */
    private String jobGroup;

    /**
     *状态 0禁用 1启用
     */
    private String jobStatus;

    /**
     * 定时表达式
     */
    private String Expression;

    /**
     * 任务描述
     */
    private String description;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getExpression() {
        return Expression;
    }

    public void setExpression(String expression) {
        Expression = expression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
