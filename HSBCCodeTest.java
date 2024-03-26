package com.example.hsbc.test;

import com.example.hsbc.utils.StringFormat;
import org.junit.Test;

public class HSBCCodeTest {

    @Test
    public void deleteTest(){
        String delteRepeat = "aabcccbbad";
        StringFormat.delteRepeat(delteRepeat, 3);
    }

    @Test
    public void replaceTest(){
        String replaceRepeat = "abcccbad";
        StringFormat.replaceRepeat(replaceRepeat, 3);
    }
}
