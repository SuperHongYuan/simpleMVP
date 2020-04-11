package com.crazy.simplemvp.model;

import androidx.annotation.NonNull;

import com.crazy.simplemvp.Constants;
import com.crazy.simplemvp.utils.SignUtil_SHA1;
import com.crazy.simplemvp.utils.XLog;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


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
 * 默认的加载器
 */
public abstract class BaseLoader {


    /**
     * 添加参数 ， 各个接口可以自行实现，如果要加入统一签名可以再这里加入
     *
     * @param map
     * @return
     */
    public Map<String, Object> getParameter(Map<String, Object> map) {
        return map;
    }


    /**
     * 签名放在头里面
     *
     * @param map
     * @return
     */
    public Map<String, Object> getHeaderRegister(Map<String, Object> map) {
        return getHeader(map, Constants.DEFAULT_SIGN_KEY);
    }


    /**
     * 签名放在头里面
     *
     * @param map
     * @return
     */
    public Map<String, Object> getHeader(Map<String, Object> map) {
        return getHeader(map, Constants.SIGN_KEY);
    }


    /**
     * token放在头里面
     *
     * @param token
     * @return
     */
    public Map<String, Object> getHeaderToken(String token) {
        Map<String, Object> headerMap = new TreeMap<>();
        headerMap.put("Authorization", token);
        return headerMap;
    }

    /**
     * token放在头里面
     * @return
     */
    public Map<String, Object> getHeaderToken() {
        Map<String, Object> headerMap = new TreeMap<>();
        headerMap.put("Authorization", Constants.Token);
        return headerMap;
    }

    private Map<String, Object> getHeader(@NonNull Map<String, Object> map, @NonNull String key) {
        StringBuffer sige = new StringBuffer();
        Map<String, Object> headerMapTyep = new TreeMap<>();
        for (String s : map.keySet()) {
            headerMapTyep.put(s.toLowerCase(),map.get(s));
        }
        XLog.d("Okhttp: " + map);
        Iterator<Map.Entry<String, Object>> iterator = headerMapTyep.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            sige.append(entry.getKey().toLowerCase()).append("=").append(entry.getValue());
            if (iterator.hasNext()) {
                sige.append("&");
            }
        }
        XLog.d("Okhttp: " + sige.toString());
        Map<String, Object> headerMap = new TreeMap<>();
        String genHMAC = SignUtil_SHA1.genHMAC(sige.toString(), key);
        if (genHMAC != null)
            headerMap.put("Authorization", genHMAC);
        return headerMap;
    }
}