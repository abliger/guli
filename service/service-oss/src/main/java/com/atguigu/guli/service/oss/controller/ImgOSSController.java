package com.atguigu.guli.service.oss.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.atguigu.guli.service.base.exception.GuliException;
import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.base.result.ResultCodeEnum;
import com.atguigu.guli.service.oss.entity.Uri;
import com.atguigu.guli.service.oss.service.ImgService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * @author abliger
 */
@Slf4j
@Api(tags = "OSS图片管理")
@RestController
@RequestMapping("/oss/admin/img")
public class ImgOSSController {
    @Autowired
    private ImgService imgService;

    /**
     * 使用element组件上传时，文件使用问号拼接的方式传递，键值为file
     */
    @ApiOperation("图片上传")
    @PostMapping("upload")
    public R saveUploadImg(@ApiParam("上传的模块名") String module, @ApiParam("上传到文件") @RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile != null) {
            log.debug("模块名：" + module + "\n 文件名：" + multipartFile.getOriginalFilename());
            String imgSaveUrl = imgService.uploadImg(module, multipartFile);
            return R.ok().data("item", imgSaveUrl);
        } else {
            throw new GuliException(ResultCodeEnum.FILE_NOT_EXIST);
        }
    }

    @ApiOperation("图片删除")
    @DeleteMapping("delete")
    public R deleteImgByUrl(@ApiParam("图片在OSS的地址") @RequestParam("url") String url) {
        if (StringUtils.isEmpty(url)) {
            throw new GuliException(ResultCodeEnum.IMG_URL_NOT_EXIST);
        }
        log.debug(url);
        imgService.deleteImgByUrl(url);
        return R.ok().message("删除成功");
    }

    @ApiOperation("批量图片删除")
    @DeleteMapping(value = "delete/batch")
    public R deleteBatchImgByUrls(@ApiParam("图片在OSS的地址") @RequestBody String url) {
        log.debug(url);
        Uri uri = JSON.parseObject(url, Uri.class);
        String[] strings = uri.getUrl();
        if (strings==null||strings.length==0) {
            throw new GuliException(ResultCodeEnum.IMG_URL_NOT_EXIST);
        }
        log.debug(Arrays.toString(strings));
        imgService.deleteBatchImgByUrls(Arrays.asList(strings));
        return R.ok().message("删除成功");
    }
}
