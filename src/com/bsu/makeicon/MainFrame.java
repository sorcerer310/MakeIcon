/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsu.makeicon;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author ugame
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        //设置图片拖放窗口
        new DropTarget(p_drag, DnDConstants.ACTION_COPY ,  new ImageDropTargetListener());  
        //设置Properties文件加密拖放窗口
        new DropTarget(p_drag_pro,DnDConstants.ACTION_COPY,new PropertiesDropTargetListener());
        try {
            //设置图标
//        Image icon = Toolkit.getDefaultToolkit().getImage("16.png");
//        this.setIconImage(icon);
            Image icon = ImageIO.read(MainFrame.class.getResource("/img/16.png"));
            this.setIconImage(icon);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //隐藏按钮 
//        bt_openIcon.setVisible(false);
        
        //-------------properties文件加密部分-----------------

        //设置默认加密
        bg_properties.add(rb_encrypt);
        bg_properties.add(rb_decrypt);
        rb_encrypt.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_properties = new javax.swing.ButtonGroup();
        p_drag = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        p_drag_pro = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        rb_encrypt = new javax.swing.JRadioButton();
        rb_decrypt = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MakeIcon v2.2 ©FC");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        p_drag.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_drag.setPreferredSize(new java.awt.Dimension(144, 144));

        jLabel7.setForeground(new java.awt.Color(128, 128, 128));
        jLabel7.setText("拖入图标(512*512)");

        javax.swing.GroupLayout p_dragLayout = new javax.swing.GroupLayout(p_drag);
        p_drag.setLayout(p_dragLayout);
        p_dragLayout.setHorizontalGroup(
            p_dragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_dragLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(54, 54, 54))
        );
        p_dragLayout.setVerticalGroup(
            p_dragLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_dragLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel7)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jLabel1.setText("图标生成");

        jLabel2.setText("Properties加密");

        p_drag_pro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        p_drag_pro.setPreferredSize(new java.awt.Dimension(144, 144));

        jLabel8.setForeground(new java.awt.Color(128, 128, 128));
        jLabel8.setText("拖入Properties文件");

        javax.swing.GroupLayout p_drag_proLayout = new javax.swing.GroupLayout(p_drag_pro);
        p_drag_pro.setLayout(p_drag_proLayout);
        p_drag_proLayout.setHorizontalGroup(
            p_drag_proLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_drag_proLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(52, 52, 52))
        );
        p_drag_proLayout.setVerticalGroup(
            p_drag_proLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_drag_proLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel8)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        rb_encrypt.setText("加密");

        rb_decrypt.setText("解密");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_drag, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_drag_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(rb_encrypt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_decrypt)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(p_drag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(rb_encrypt)
                            .addComponent(rb_decrypt))
                        .addGap(6, 6, 6)
                        .addComponent(p_drag_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 通过导入的图标生成所有尺寸的图标
     * @param path 源图标的路径
     */
    private void makeImage(String path) throws IOException{
        File png = new File(path);
        int[] size = ImageHelper.getPNGSize(png);
        if((size[0]!=512 || size[1]!=512) && (size[0]!=256 || size[1]!=256)){
            JOptionPane.showMessageDialog(MainFrame.this, "您选择的图标尺寸不合适，请选择512*512或256*256尺寸的图标");
            return;
        }
        //生成路径一些保存图标的若干路径
        String makePath = png.getParent()+"/icons/";
        makeFolders(makePath);
        String makeIosPath = png.getParent()+"/icons/ios/";
        makeFolders(makeIosPath);
        String makeAndroidPath = png.getParent()+"/icons/android/";
        makeFolders(makeAndroidPath);

        int[] pngsize = {28,32,36,48,57,72,76,96,100,108,114,120,144,152,175,192,256};  //设置所有的尺寸
        
        HashMap<Integer,String> hm_ios = new HashMap<Integer,String>();             //ios根据不同的尺寸为不同的文件命名
        hm_ios.put(57, "Icon");
        hm_ios.put(114, "Icon@2x");
        hm_ios.put(72, "Icon-72");
        hm_ios.put(144, "Icon-72@2x");
        hm_ios.put(120, "Icon-60@2x");
        hm_ios.put(76, "Icon-76");
        hm_ios.put(152, "Icon-76@2x");
        
        HashMap<Integer,String> hm_android = new HashMap<Integer,String>();     //android根据不同尺寸为不同的图标设置保存路径
        hm_android.put(48, "drawable-mdpi");
        hm_android.put(72, "drawable-hdpi");
        hm_android.put(96, "drawable-xhdpi");
        hm_android.put(144, "drawable-xxhdpi");
        hm_android.put(192, "drawable-xxxhdpi");
        
        
        //生成不同尺寸图标
        for(int i=0;i<pngsize.length;i++){
            //生成以尺寸命名的图标文件
            StringBuilder sb = new StringBuilder();
            sb.append(makePath)
                    .append(Integer.toString(pngsize[i])) 
                    .append(".png"); 
                    
            ImageHelper.resizePNG(png, sb.toString(), pngsize[i], pngsize[i], false); 

            //如果当前包含符合ios尺寸的图标.
            if(hm_ios.containsKey(pngsize[i])){
                sb = new StringBuilder();
                sb.append(makeIosPath)
                        .append(hm_ios.get(pngsize[i]))
                        .append(".png");
                ImageHelper.resizePNG(png, sb.toString(), pngsize[i], pngsize[i], false);
            }
            
            //如果当前包含符合android尺寸的图标.
            if(hm_android.containsKey(pngsize[i])){
                sb = new StringBuilder();
                sb.append(makeAndroidPath)
                        .append(hm_android.get(pngsize[i]))
                        .append("/");
                makeFolders(sb.toString());
                sb.append("ic_launcher.png");
                ImageHelper.resizePNG(png, sb.toString(), pngsize[i], pngsize[i], false);
            }
        }
    }
    /**
     * 根据路径创建文件夹
     * @param path  路径名
     */
    private void makeFolders(String path){
        File f = new File(path);
        f.mkdir();
        f = null;
    }
    
    /**
     * 生成加密的Properties
     * @param f          原始Properties文件
     * @throws IOException 
     */
    private void makeEncryptProperties(File f) throws IOException{
        Properties p_read = null;                                               //负责读取的Properties
        Properties p_write = null;                                              //负责写入的Properties
        String savePath = null;
        try {
            //选择加密
            if(this.rb_encrypt.isSelected()){
                p_write = new EncryptedProperties("ugame001");
                p_read = new Properties();
                savePath = "/encrypty/";
            //选择解密
            }else if(this.rb_decrypt.isSelected()){
                p_read = new EncryptedProperties("ugame001");
                p_write = new Properties();
                savePath = "/decrypty/";
            }
//            EncryptedProperties ep = new EncryptedProperties("ugame001");       //加密写入Properties对象
//            Properties p = new Properties();                                    //读取原始文件Properties对象
            //读取文件,并将读入的数据设置到写对象中
            FileInputStream fis = new FileInputStream(f);
            p_read.load(fis);
            Set<Map.Entry<Object,Object>> e = p_read.entrySet();
            Iterator<Map.Entry<Object,Object>> i = e.iterator();
            while(i.hasNext()){
                Map.Entry<Object,Object> entry = i.next();
                String value = p_read.getProperty(entry.getKey().toString());
                p_write.setProperty(entry.getKey().toString(), value);
            }
            fis.close();
            
            //先生成路径,再生成文件
            String makepath = f.getParent()+savePath;
            File pngpath = new File(makepath);
            boolean b = pngpath.mkdir();
            //生成文件
            File f_write = new File(f.getParent()+savePath+f.getName());
            FileOutputStream out = new FileOutputStream(f_write);
            p_write.store(out, "encrypt properties");
            out.close();
            
            
        } catch (Exception ex) {
            Logger.getLogger(PropertiesHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * 图片拖放监听器
     */
    class ImageDropTargetListener extends DropTargetAdapter  
    {  
        public void drop(DropTargetDropEvent event)  
        {  
            //接受复制操作  
            event.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);  
            //获取拖放的内容  
            Transferable transferable = event.getTransferable();  
            DataFlavor[] flavors = transferable.getTransferDataFlavors();  
            //遍历拖放内容里的所有数据格式  
            for (int i = 0; i < flavors.length; i++)  
            {    
                DataFlavor d = flavors[i];  
                try  
                {  
                    //如果拖放内容的数据格式是文件列表  
                    if (d.equals(DataFlavor.javaFileListFlavor))  
                    {  
                        //取出拖放操作里的文件列表  
                        java.util.List fileList   
                            = (java.util.List) transferable.getTransferData(d);  
                        for (Object f : fileList)  
                        {  
                            //显示每个文件  
//                            showImage((File)f , event);  
                            
                            makeImage(((File)f).getPath());
                        }  
                    }  
                }  
                catch (Exception e)  
                {    
                    e.printStackTrace();  
                }  
                //强制拖放操作结束，停止阻塞拖放源  
                event.dropComplete(true);  
            }  
        }  
        
        //显示每个文件的工具方法  
        private void showImage(File f , DropTargetDropEvent event)throws java.io.IOException  
        {  
//            Image image = ImageIO.read(f);  
//            if (image == null)  
//            {  
//                //强制拖放操作结束，停止阻塞拖放源  
//                event.dropComplete(true);  
//                JOptionPane.showInternalMessageDialog(desktop , "系统不支持这种类型的文件");  
//                //方法返回，不会继续操作  
//                return;  
//            }  
//            ImageIcon icon = new ImageIcon(image);  
//            //创建内部窗口显示该图片  
//            JInternalFrame iframe = new JInternalFrame(f.getName()  
//                ,true , true , true , true);  
//            JLabel imageLabel = new JLabel(icon);  
//            iframe.add(new JScrollPane(imageLabel));  
//            desktop.add(iframe);  
//            //设置内部窗口的原始位置（内部窗口默认大小是0X0，放在0,0位置）  
//            iframe.reshape(nextFrameX, nextFrameY, width, height);  
//            //使该窗口可见，并尝试选中它  
//            iframe.show();  
//            //计算下一个内部窗口的位置  
//            nextFrameX += FRAME_DISTANCE;  
//            nextFrameY += FRAME_DISTANCE;  
//            if (nextFrameX + width > desktop.getWidth()) nextFrameX = 0;  
//            if (nextFrameY + height > desktop.getHeight()) nextFrameY = 0;  
        }  
    }
    
    /**
     * Properties文件监听器
     */
    class PropertiesDropTargetListener extends DropTargetAdapter{
        public void drop(DropTargetDropEvent event) {
            //接受复制操作  
            event.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);  
            //获取拖放的内容  
            Transferable transferable = event.getTransferable();  
            DataFlavor[] flavors = transferable.getTransferDataFlavors();  
            //遍历拖放内容里的所有数据格式  
            for (int i = 0; i < flavors.length; i++)  
            {    
                DataFlavor d = flavors[i];  
                try  
                {  
                    //如果拖放内容的数据格式是文件列表  
                    if (d.equals(DataFlavor.javaFileListFlavor))  
                    {  
                        //取出拖放操作里的文件列表  
                        java.util.List fileList   
                            = (java.util.List) transferable.getTransferData(d);  
                        for (Object f : fileList)  
                        {  
                            //显示每个文件  
//                            showImage((File)f , event); 
//                            makeEncryptProperties(((File)f).getPath());
//                            makeEncryptProperties(f);
                            makeEncryptProperties(((File)f));
                        }  
                    }  
                }  
                catch (Exception e)  
                {    
                    e.printStackTrace();  
                }  
                //强制拖放操作结束，停止阻塞拖放源  
                event.dropComplete(true);  
            }  
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_properties;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel p_drag;
    private javax.swing.JPanel p_drag_pro;
    private javax.swing.JRadioButton rb_decrypt;
    private javax.swing.JRadioButton rb_encrypt;
    // End of variables declaration//GEN-END:variables
}
