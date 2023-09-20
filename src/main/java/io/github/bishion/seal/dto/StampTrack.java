package io.github.bishion.seal.dto;


import java.util.Date;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/4-20:27
 */
public class StampTrack {
    //////////////////// 基础静态信息 ///////////////////////
    /**
     * 应用程序名称
     */
    private String appName;
    /**
     * 主机ip
     */
    private String hostIp;
    /**
     * 主机名
     */
    private String hostName;

    //////////////////// 请求信息 ///////////////////////
    /**
     * 客户端ip
     */
    private String clientIp;
    /**
     * 操作人
     */
    private String operatorNo;
    /**
     * 操作人姓名
     */
    private String operatorName;
    //////////////////// 注解信息 ///////////////////////
    /**
     * 模块
     */
    private String module;
    /**
     * 操作类型
     */
    private String actionType;
    /**
     * 操作
     */
    private String action;

    /**
     * 参数
     */
    private String param;
    /**
     * 参数
     */
    private String bizNo;
    //////////////////// 执行信息 ///////////////////////

    /**
     * 响应
     */
    private String response;
    /**
     * 成功还是失败
     * SUCCESS；FAILURE
     */
    private String success;

    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 执行时间ms
     */
    private Long costTime;


    public static StampTrackBuilder builder() {
        return new StampTrackBuilder();
    }

    public static class StampTrackBuilder {
        private StampTrack stampTrack = new StampTrack();

        public StampTrackBuilder appName(String appName) {
            stampTrack.appName = appName;
            return this;
        }

        public StampTrackBuilder hostIp(String hostIp) {
            stampTrack.hostIp = hostIp;
            return this;
        }

        public StampTrackBuilder hostName(String hostName) {
            stampTrack.hostName = hostName;
            return this;
        }

        public StampTrackBuilder module(String module) {
            stampTrack.module = module;
            return this;
        }

        public StampTrackBuilder actionType(String actionType) {
            stampTrack.actionType = actionType;
            return this;
        }

        public StampTrackBuilder clientIp(String clientIp) {
            stampTrack.clientIp = clientIp;
            return this;
        }

        public StampTrackBuilder operatorNo(String operatorNo) {
            stampTrack.operatorNo = operatorNo;
            return this;
        }

        public StampTrackBuilder operatorName(String operatorName) {
            stampTrack.operatorName = operatorName;
            return this;
        }

        public StampTrackBuilder param(String param) {
            stampTrack.param = param;
            return this;
        }

        public StampTrackBuilder bizNo(String bizNo) {
            stampTrack.bizNo = bizNo;
            return this;
        }

        public StampTrack build() {
            return stampTrack;
        }
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }
}
