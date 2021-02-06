package com.sterefine.energetic;

import com.sterefine.energetic.exception.ApiException;
import com.sterefine.energetic.exception.ResponseException;
import com.sterefine.energetic.exception.ResultCode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: doudai
 * 2020/7/22
 */
public class ExceptionTest {

    @Test
    public void test1() {
        try {
            ResponseException.BUSINESS_EXCEPTION.notNull(null, "hello");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            ResponseException.BUSINESS_EXCEPTION.notNull(null, 123, "hello");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            ResponseException.BUSINESS_EXCEPTION.fail("failed");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            ResponseException.BUSINESS_EXCEPTION.fail(123, "abaaaa");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void test2() {
        try {
            ApiException.notNull(null, "apihello1");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            ApiException.notNull(null, 123, "api123");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            ApiException.notNull(null, ResultCode.builder().msg("null - api").code(123).build());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            ApiException.notEmpty(new ArrayList<>(), 123, "message123", ResultCode.builder().msg("empty").code(123).build(), "context 1", "args 2");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            ApiException.state(false, 123, "messagestate", ResultCode.builder().msg("empty").code(123).build(), "context 2", "args 2");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            ApiException.state(false, 123, "messagestate", "context 2", "args 2", "arfefefef");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
