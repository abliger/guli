package com.atguigu.guli.service.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.atguigu.guli.service.oss.entity.OssConfigBean;
import com.atguigu.guli.service.oss.service.ImgService;
import com.atguigu.guli.service.oss.util.GetFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author abliger
 */
@Slf4j
@Service
public class ServiceImpl implements ImgService {
    @Autowired
    private OssConfigBean OssConfigBean;
    @Autowired
    private OSS OSS;

    @Override
    public String uploadImg(String module, MultipartFile multipartFile) {
        String bucketName = OssConfigBean.getBucketName();
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String fileName = module + "/" + GetFile.getFile(multipartFile);
        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
        try {
            InputStream inputStream = multipartFile.getInputStream();
            OSS.putObject(bucketName, fileName, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }

    @Override
    public void deleteImgByUrl(String url) {
        String bucketName = OssConfigBean.getBucketName();
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        //https://guli-abliger-file.oss-cn-shanghai.aliyuncs.com/null/2020/11/06/e98100c4-0e35-4572-b700-f6e9043bcf86.jpg
        OSS.deleteObject(bucketName, url);
    }

    @Override
    public void deleteBatchImgByUrls(List<String> url) {
        String bucketName = OssConfigBean.getBucketName();
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        //https://guli-abliger-file.oss-cn-shanghai.aliyuncs.com/null/2020/11/06/e98100c4-0e35-4572-b700-f6e9043bcf86.jpg
        DeleteObjectsRequest request=new DeleteObjectsRequest(bucketName).withKeys(url);
        OSS.deleteObjects(request);
    }
}
