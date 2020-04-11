package com.crazy.simplemvp.bean.response;


/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: App
 * Author: huang
 * Date: 2020/4/11 15:03
 * Description:
 * History:
 * 作者：<author>
 * 修改时间：<time>
 * 版本：<version>
 * If the implementation is hard to explain, it's a bad idea.
 * If the implementation is easy to explain, it may be a good idea.
 *
 * 基础的请求封装 应该符合通用的接口规则
 * @param <T> 实际的数据类
 */
public class BaseResult<T> {

    /**
     * ResponseStatus : {"ErrorCode":"0","Message":null}
     * Data : {}
     */

    private BaseResult.ResponseStatusBean ResponseStatus;
    private T Data;

    public BaseResult.ResponseStatusBean getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(BaseResult.ResponseStatusBean responseStatus) {
        this.ResponseStatus = responseStatus;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        this.Data = data;
    }

    public static class ResponseStatusBean {
        /**
         * ErrorCode : 0
         * Message : null
         */

        private String ErrorCode;
        private String Message;

        public String getErrorCode() {
            return ErrorCode;
        }

        public void setErrorCode(String errorCode) {
            this.ErrorCode = errorCode;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            this.Message = message;
        }

        @Override
        public String toString() {
            return "ResponseStatusBean{" +
                    "ErrorCode='" + ErrorCode + '\'' +
                    ", Message='" + Message + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResponseBaseBean{" +
                "ResponseStatus=" + ResponseStatus +
                ", Data=" + Data +
                '}';
    }
}
