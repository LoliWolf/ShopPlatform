package com.sp.utils;

import java.util.ArrayList;
import java.util.Collections;

public class MathUtils {
    public static String getRandomNumString(int size){
        String num = "";
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<10;i++){
            arr.add(String.valueOf(i));
        }
        for(int i=0;i<size;i++){
            Collections.shuffle(arr);
            if("0".equals(arr.get(0))){
                i--;
            }
            else{
                num += arr.get(0);
            }
        }
        return num;
    }
}