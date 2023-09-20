package io.github.bishion.seal.dto;
import java.io.Serializable;

/**
 * 基本操作信息
 *
 * @author: guofangbi
 * @since: 2022-06-13 22:23:14
 * @version: 1.0.0
 */
public class ReqInfo implements Serializable {

    /**
     * 当前登陆人
     */
    private String operatorNo;
    /**
     * 当前登陆人姓名
     */
    private String operatorName;


    /**
     * 客户端IP
     */
    private String clientIp;

    @Override
    public String toString() {
        return "ReqInfo{" +
                "operatorNo='" + operatorNo + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", clientIp='" + clientIp + '\'' +
                '}';
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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}
