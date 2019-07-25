/**
 * <p>Title: shellUtils2</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/5/31
 */
package com.cn.jk.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shellUtils2 {
    public static void runShel(String path){
        BufferedReader reader = null;
        try{
            String res =  "#!/bin/bash echo \"Hello World! \""   ;
//            String bashCommand = "sh "+ res;
//            String bashCommand = "chmod 777 " + "\"D:\\java_files2\\aaa.sh\"" ;
            String bashCommand = "sh " + path ;
            Runtime runtime = Runtime.getRuntime();
            Process pro = runtime.exec(bashCommand);
            int status = pro.waitFor();
            if (status != 0)
            {
                System.out.println("Failed to call shell's command ");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            StringBuffer strbr = new StringBuffer();
            String line;
            while ((line = br.readLine())!= null)
            {
                strbr.append(line).append("\n");
            }

            String result = strbr.toString();
            System.out.println(result);

        }
        catch (IOException ec)
        {
            ec.printStackTrace();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();

        }
    }
    }
