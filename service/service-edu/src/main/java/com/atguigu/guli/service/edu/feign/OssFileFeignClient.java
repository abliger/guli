package com.atguigu.guli.service.edu.feign;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.feign.impl.OSSFileFeignClientImpl;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author abliger
 */
@Service
@FeignClient(value = "service-oss",fallback = OSSFileFeignClientImpl.class)
public interface OssFileFeignClient {

    @DeleteMapping("/oss/admin/img/delete")
    R deleteImgByUrl(@ApiParam("图片在OSS的地址") @RequestParam("url") String url);


    @DeleteMapping("/oss/admin/img/delete/batch")
    R deleteBatchImgByUrls(@ApiParam("图片在OSS的地址")@RequestBody String url);
}
