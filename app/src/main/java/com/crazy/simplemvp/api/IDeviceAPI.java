package com.crazy.simplemvp.api;

import com.crazy.simplemvp.bean.response.BaseResult;
import com.crazy.simplemvp.bean.response.RegisterEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: IDeviceAPI
 * Author: huang
 * Date: 2020/4/11 17:18
 * Description:
 * History:
 * 作者：<author>
 * 修改时间：<time>
 * 版本：<version>
 * If the implementation is hard to explain, it's a bad idea.
 * If the implementation is easy to explain, it may be a good idea.
 *
 * 设备API
 */
public interface IDeviceAPI {


    /**
     * 设备注册接口 TOKEN 验证 版权原因 接口实际地址隐藏
     *
     * @param header 请求头
     *               Authorization = {@link com.crazy.simplemvp.utils.SignUtil_SHA1#genHMAC(String, String)} map , def_key
     * @param map    请求体
     *               {
     *               "TerminalType": 41543,
     *               "MacID": "58156",
     *               "Sign": "OqBzPlpPmq",
     *               "TS": 57023
     *               }
     * @return RegisterEntity
     */
    @POST("/Hardware/api/v1.0/Public/******")
    Observable<BaseResult<RegisterEntity>> deviceRegister(@HeaderMap Map<String, Object> header, @Body Map<String, Object> map);


}
