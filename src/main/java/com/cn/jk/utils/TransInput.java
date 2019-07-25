/**
 * <p>Title: TransInput</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/5/31
 */
package com.cn.jk.utils;

import java.io.*;

public class TransInput {
    /**
     * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
     *
     * @param res   原字符串
     * @param filePath 文件路径
     * @return 成功标记
     */
    public static boolean string2File(String res, String filePath) {
        boolean flag = true;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            String destDirName="d:\\java_files2";
            File dir = new File(destDirName);
            if (!dir.exists()){
                dir.mkdirs();
            }
            if (dir.exists()) {
                System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
                File file = new File(destDirName +"\\aaa"+ ".sh");
                System.out.println(file+"file");

                //如果文件不存在，则新建一个
                if(!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(  ".txt文件不存在");
                }
            }
            File file = new File("aaa" + ".txt");
            File distFile = new File(filePath);
            if (!distFile.getParentFile().exists()) distFile.getParentFile().mkdirs();

            bufferedReader = new BufferedReader(new StringReader(res));
            bufferedWriter = new BufferedWriter(new FileWriter(distFile));
            char buf[] = new char[1024];         //字符缓冲区
            int len;
            while ((len = bufferedReader.read(buf)) != -1) {
                bufferedWriter.write(buf, 0, len);
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            return flag;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
