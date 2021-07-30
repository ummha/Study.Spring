package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 제이슨 to DTO 디자인
 * 제이슨 예시 >>>
 * {
 *     "header" : {
 *      "response_code" : "OK"
 *     },
 *     "body" : {
 *         "name" : "steve",
 *         "age" : 25
 *     }
 * }
 * >>>
 * @param <T>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req<T> {

    private Header header;
    private T responseBody;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header{
        private String responseCode;
    }
}
