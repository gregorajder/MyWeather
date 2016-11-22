package com.gregorajdergmail.myweather;

import com.gregorajdergmail.myweather.util.MyUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void date_isCorrect() throws Exception {
        assertEquals("21/11/2016 понедельник", MyUtils.convertDate(1479726000));
    }
}