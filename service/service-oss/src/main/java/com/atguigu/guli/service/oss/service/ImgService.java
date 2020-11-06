package com.atguigu.guli.service.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author abliger
 */

public interface ImgService {
    String uploadImg(String module, MultipartFile multipartFile);

    void deleteImgByUrl(String url);

    void deleteBatchImgByUrls(List<String> url);
}
