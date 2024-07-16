package com.wsd;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
Map<String, String> map=new HashMap<>();
map.put("pr","+88(00)01941876138");
        System.out.println(getTranzwareFormattedMobileNumber(map.get("pr")));


    }
    public static String getTranzwareFormattedMobileNumber(String mobileNumber){
        if (mobileNumber == null || mobileNumber.equals("null"))
            return "";
        mobileNumber = mobileNumber.replace("+0()", "").
                replace("+", "").replace("(", "").replace(")", "");

        if (mobileNumber.length() > 10) {
            mobileNumber=mobileNumber.substring(mobileNumber.length()-10);
            String first = mobileNumber.substring(0, 4);
            String last = mobileNumber.substring(4);
            return  "880(" + first + ")" + last;
        }
        return mobileNumber;
    }

}
