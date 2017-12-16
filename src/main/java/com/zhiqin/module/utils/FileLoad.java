package com.zhiqin.module.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 文件上传
 *
 * @author Maple
 */
@Component
public class FileLoad {
    @Value("${files.diskPath}")
    private String diskPath;

    public List getImgFile(MultipartFile[] file, String tables) {
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
        List list = new ArrayList();
        String photos1 = "";//最后保存的图片
        String fileName = "";
//        String strPhotos = "";
        System.out.println("开始");
        for (int i = 0; i < file.length; i++) {
//	        String fileName = file[i].getOriginalFilename();
            String suffix = file[i].getOriginalFilename().substring
                    (file[i].getOriginalFilename().lastIndexOf("."));
//	        String path = request.getSession().getServletContext().getRealPath("upload");
            fileName = "";
            fileName = System.currentTimeMillis() + suffix;//重新生成文件名称
//            String date1 = sdf1.format(date);
//            String pathDate = date1 + File.separator;
            String strPaths = "";
            switch (tables) {
                case "customer":
                    strPaths = diskPath + File.separator;//生成一个保存路径
                    break;
                default:
                    break;
            }
            File files = new File(strPaths);  //保存路径
            //如果文件夹不存在则创建
            if (!files.exists() && !files.isDirectory()) {
                System.out.println("//不存在");
                files.mkdir();
            }
//            strPhotos =fileName;//该图片的保存名称
//	        String fileName = new Date().getTime()+".jpg";
            System.out.println(strPaths);
            File targetFile = new File(strPaths, fileName);
            //保存
            try {
                file[i].transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(fileName);
        }
        return list;
    }


    public String getImgFileText(MultipartFile[] file) {
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
        String fileName = "";
        String strPhotos = "";
        System.out.println("开始");
        for (int i = 0; i < file.length; i++) {
            String suffix = file[i].getOriginalFilename().substring
                    (file[i].getOriginalFilename().lastIndexOf("."));
            fileName = "";
            fileName = System.currentTimeMillis() + suffix;//重新生成文件名称
            String date1 = sdf1.format(date);
            String pathDate = diskPath + File.separator + date1 + File.separator;
            File files = new File(pathDate);  //保存路径
            //如果文件夹不存在则创建
            if (!files.exists() && !files.isDirectory()) {
                System.out.println("//不存在");
                files.mkdirs();
            }
            strPhotos = date1 + "/" + fileName;//该图片的保存名称
            System.out.println(pathDate);
            File targetFile = new File(pathDate, fileName);
            //保存
            try {
                file[i].transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strPhotos;
    }


    /**
     * 将接收到的base64转为图片
     * *@author Maple
     */
    // base64字符串转化成图片
    public String GenerateImage(String imgStr, String tables) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return "";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            String imgPath = System.currentTimeMillis() + RandomCode.random() + ".jpg";//图片名称
            String strPath = "";
            switch (tables) {
                case "customer":
                    strPath = diskPath + File.separator;//生成一个保存路径
                    break;

                default:
                    break;
            }
            File file = new File(strPath);
            //如果文件夹不存在则创建
            if (!file.exists() && !file.isDirectory()) {
                System.out.println("//不存在");
                file.mkdir();
            }
            String imgFilePath = strPath + imgPath;// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return imgPath;
        } catch (Exception e) {
            return "";
        }
    }
}