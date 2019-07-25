/**
 * <p>Title: shellUtils</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/5/31
 */
package com.cn.jk.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class shellUtils {

    public static void executeShell(String shpath,String scriptArgs){
        try {
            if (scriptArgs==null) scriptArgs="";
            Process ps = Runtime.getRuntime().exec("sh "+shpath+scriptArgs);
            ps.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
