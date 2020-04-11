package com.crazy.simplemvp.model;

import com.crazy.simplemvp.Constants;
import com.crazy.simplemvp.api.IDeviceAPI;
import com.crazy.simplemvp.bean.response.BaseResult;
import com.crazy.simplemvp.bean.response.RegisterEntity;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
 * 设备管理加载器
 */
public class DeviceMangeLoader extends BaseLoader {

    /**
     * 注册接口
     *
     * @param map      <br/>{
     *                 "TerminalType": 63427,
     *                 "MacID": "65431",
     *                 "Sign": "KeW37sB1JQ",
     *                 "TS": 26907
     *                 }<br/>
     * @param observer 响应
     */
    public final void register(Map<String, Object> headMap, Map<String, Object> map, Observer<BaseResult<RegisterEntity>> observer) {
        ApiWrapper.getInstance(Constants.BASE_URL)
                .create(IDeviceAPI.class)
                .deviceRegister(getHeaderRegister(headMap), getParameter(map))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
