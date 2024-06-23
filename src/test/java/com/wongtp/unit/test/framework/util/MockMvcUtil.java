/*
 * Copyleft
 */
package com.wongtp.unit.test.framework.util;

import cn.hutool.json.JSONUtil;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

/**
 * @author wongtp
 * @date 2024-05-30
 */
public class MockMvcUtil {

    public static MockHttpServletRequestBuilder post(String url, Object body) {
        try {
            return MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .characterEncoding(StandardCharsets.UTF_8)
                    .content(JSONUtil.toJsonStr(body));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
