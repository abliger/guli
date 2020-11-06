package com.atguigu.guli.service.edu.feign.impl;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.base.result.ResultCodeEnum;
import com.atguigu.guli.service.edu.feign.OssFileFeignClient;
import lombok.extern.slf4j.Slf4j;
import sun.util.calendar.LocalGregorianCalendar;

/**
 * @author abliger
 */
@Slf4j
public class OSSFileFeignClientImpl implements OssFileFeignClient {
    @Override
    public R deleteImgByUrl(String url) {
        log.error("deleteImgByUrl远程调用失败");
        return R.setResult(ResultCodeEnum.FEIGN_REMOTE_FAIL);
    }

    @Override
    public R deleteBatchImgByUrls(String url) {
        log.error("deleteBatchImgByUrls远程调用失败");
        return R.setResult(ResultCodeEnum.FEIGN_REMOTE_FAIL);
    }
}
