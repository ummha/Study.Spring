package com.example.client.dto;

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

public class Req<T> {
    private Header header;
    private T responseBody;

    public static class Header{
        private String responseCode;

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        @Override
        public String toString() {
            return "Header{" +
                    "responseCode='" + responseCode + '\'' +
                    '}';
        }
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "Req{" +
                "header=" + header +
                ", body=" + responseBody +
                '}';
    }
}
