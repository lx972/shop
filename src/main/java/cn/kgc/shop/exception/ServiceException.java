package cn.kgc.shop.exception;

/**
 * 服务层异常
 *
 * @Author Administrator
 * @date 16:05
 */
public class ServiceException extends RuntimeException {

    private Integer code;

    private String msg;

    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
