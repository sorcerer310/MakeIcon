package com.bsu.makeicon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEParameterSpec;

@SuppressWarnings("serial")
public class EncryptedProperties extends Properties {
	private static sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    private static sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    private Cipher encrypter, decrypter;
    private static byte[] salt = { (byte) 0x03, 0x05,0x07,0x11,0x23,0x23,0x32,0x4d};  
 
    public EncryptedProperties(String password) throws Exception {
        PBEParameterSpec ps = new javax.crypto.spec.PBEParameterSpec(salt, 20);
        SecretKeyFactory kf = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey k = kf.generateSecret(new javax.crypto.spec.PBEKeySpec(password.toCharArray()));
        encrypter = Cipher.getInstance("PBEWithMD5AndDES/CBC/PKCS5Padding");
        decrypter = Cipher.getInstance("PBEWithMD5AndDES/CBC/PKCS5Padding");
        encrypter.init(Cipher.ENCRYPT_MODE, k, ps);
        decrypter.init(Cipher.DECRYPT_MODE, k, ps);
    }
 
    public String getProperty(String key) {
        try {
            return decrypt(super.getProperty(key));
        } catch( Exception e ) {
            throw new RuntimeException("Couldn't decrypt property");
        }
    }
 
    public synchronized Object setProperty(String key, String value) {
        try {
            return super.setProperty(key, encrypt(value));
        } catch( Exception e ) {
            throw new RuntimeException("Couldn't encrypt property");
        }
    }
 
    private synchronized String decrypt(String str) throws Exception {
        byte[] dec = decoder.decodeBuffer(str);
        byte[] utf8 = decrypter.doFinal(dec);
        return new String(utf8, "UTF-8");
    }
 
    private synchronized String encrypt(String str) throws Exception {
        byte[] utf8 = str.getBytes("UTF-8");
        byte[] enc = encrypter.doFinal(utf8);
        return encoder.encode(enc);
    }
	
    public static void main(String[] args){
    	System.out.println("EncryptedProperties");
//    	EncryptedProperties.
		try {
		
		//-----------读取未加密的原始Properties文件---------
	    	Properties p = new Properties();
	    	FileInputStream fis;

		//此处的文件路径,要根据android项目实际情况写入
		fis = new FileInputStream(EncryptedProperties.class.getClassLoader().getResource("").getPath()+"aaa.properties");
	    	p.load(fis);																//加载属性文件
	    	p.list(System.out);															//打印属性文件中所有内容
	    	System.out.println(p.getProperty("hello")+"+"+p.getProperty("number"));		//分别获得两个属性的值并打印出来


	    	//-----------创建保存加密Properties文件的Properties对象,密码为ugame001---------
	    	EncryptedProperties ep = new EncryptedProperties("ugame001");
	    	Set<Map.Entry<Object,Object>> e = p.entrySet();
	    	Iterator<Map.Entry<Object,Object>> i = e.iterator();
	    	//获得未加密Properties文件的内容,并将没一项的值都加密
	    	while(i.hasNext()){
	    		Map.Entry<Object,Object> entry = i.next();
	    		ep.setProperty(entry.getKey().toString(), entry.getValue().toString());
	    	}
	    	//将加密后的文件的文件命名为aaa_.properties保存到磁盘
	    	File f = new File(EncryptedProperties.class.getClassLoader().getResource("").getPath()+"aaa_.properties");
	        FileOutputStream out = new FileOutputStream(f);
	        ep.store(out, "aaa_.properties");
	        out.close();
	        
	        //------------读取加密后的Properties文件内容-----------
	        EncryptedProperties epr = new EncryptedProperties("ugame001");
	        FileInputStream fis_epr;
	        fis_epr = new FileInputStream(EncryptedProperties.class.getClassLoader().getResource("").getPath()+"aaa_.properties");
	        epr.load(fis_epr);
	        p.list(System.out);
	        

	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}

