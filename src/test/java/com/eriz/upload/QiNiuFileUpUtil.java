package com.eriz.upload;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.junit.Test;

import java.io.IOException;

public class QiNiuFileUpUtil {
    /**基本配置-从七牛管理后台拿到*/
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "8-HMj9EgGNIP-xuOCpSzTn-OMyGOFtR3TxLdn4Uu";
    String SECRET_KEY = "SjpGg3V6PsMdJgn42PeEd5Ik-6aNyuwdqV5CPM6A";
    //要上传的空间名--
    String bucketname = "ifast";
    //访问地址http://oswj11a86.bkt.clouddn.com/daimo6.png     url + fileName
    String url = "http://oswj11a86.bkt.clouddn.com";

//    accessKey: 8-HMj9EgGNIP-xuOCpSzTn-OMyGOFtR3TxLdn4Uu
////    secretKey: SjpGg3V6PsMdJgn42PeEd5Ik-6aNyuwdqV5CPM6A
////    bucket: ifast
////    accessURL: http://p6r7ke2jc.bkt.clouddn.com/

    /**指定保存到七牛的文件名--同名上传会报错  {"error":"file exists"}*/
    /** {"hash":"FrQF5eX_kNsNKwgGNeJ4TbBA0Xzr","key":"aa1.jpg"} 正常返回 key为七牛空间地址 http:/xxxx.com/aa1.jpg */
    //上传文件的路径
    String FilePath ="C:\\Users\\Administrator\\Desktop\\eriz\\kwallpaper.jpg";
    //上传到七牛后保存的文件名    访问为：http://oswj11a86.bkt.clouddn.com/daimo6.png
    String key = "daimo6.png";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager =new UploadManager(new Configuration());


    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
            System.out.println(res.statusCode);//200为上传成功
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    @Test
    public void main() throws IOException{
        new QiNiuFileUpUtil().upload();
    }
}
