package com.atguigu.guli.service.edu.controller.Feign;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.feign.OssFileFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.List;

/**
 * @author abliger
 */
@Slf4j
@Api(tags = "OSS远程调用")
@RestController
@RequestMapping("edu/admin/ossRemote")
public class OssFeignController {
    @Autowired
    private OssFileFeignClient ossFileFeignClient;

    @ApiOperation("图片删除")
    @DeleteMapping("delete")
    public R deleteImgByUrl(@ApiParam("图片在OSS的地址") @RequestParam String url){
        log.debug("图片删除url:"+url);
        return ossFileFeignClient.deleteImgByUrl(url);
    }

    @ApiOperation("批量图片删除")
    @DeleteMapping("delete/batch")
    public R deleteBatchImgByUrls(@ApiParam("图片在OSS的地址")@RequestBody String url){
        log.debug(url);
        return ossFileFeignClient.deleteBatchImgByUrls(url);
    }
}
