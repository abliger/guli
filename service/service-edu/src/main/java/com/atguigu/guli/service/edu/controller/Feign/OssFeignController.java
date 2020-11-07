package com.atguigu.guli.service.edu.controller.Feign;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.feign.OssFileFeignClient;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public R deleteImgByUrl(@ApiParam(value = "图片在OSS的地址" ,
            examples=@Example({@ExampleProperty(mediaType = "application/json", value = "{'url'='avater/2020/11/06/xxx.jpg'}")})) @RequestParam String url){
        log.debug("图片删除url:"+url);
        return ossFileFeignClient.deleteImgByUrl(url);
    }

    @ApiOperation("批量图片删除")
    @DeleteMapping("delete/batch")
    public R deleteBatchImgByUrls(@ApiParam(value="图片在OSS的地址",
            examples=@Example(value = @ExampleProperty(mediaType = "application/json", value = "{'url':'[avater/2020/11/06/xxx.jpg, avater/2020/11/06/xxx.jpg, avater/2020/11/06/xxx.jpg]'}")))
                                      @RequestBody String url){
        log.debug(url);
        return ossFileFeignClient.deleteBatchImgByUrls(url);
    }
}
