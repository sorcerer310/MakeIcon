/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsu.makeicon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  用来加密或解密一个Properties文件
 * @author fc
 */
public class PropertiesHelper {
    /**
     * 将一个properties文件的值进行加密
     * @param f 带入的原始加密文件
     */
    public static synchronized void encrypt(File f){
        try {
            EncryptedProperties ep = new EncryptedProperties("ugame001");           //加密写入Properties对象
            Properties p = new Properties();                                        //读取原始文件Properties对象

            FileInputStream fis = new FileInputStream(f);
            p.load(fis);
            Set<Map.Entry<Object,Object>> e = p.entrySet();
            Iterator<Map.Entry<Object,Object>> i = e.iterator();
            while(i.hasNext()){
                Map.Entry<Object,Object> entry = i.next();
                ep.setProperty(entry.getKey().toString(), entry.getValue().toString());
            }
            
            File epf = new File(f.getPath()+"/encrypt/"+f.getName());
            FileOutputStream out = new FileOutputStream(epf);
            ep.store(out, "encrypt properties");
            out.close();
            
        } catch (Exception ex) {
            Logger.getLogger(PropertiesHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 将一个properties文件的值进行解密
     * @param f 
     */
    public synchronized void decrypt(File f){
        
    }
    
}
