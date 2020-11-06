package com.atguigu.guli.service.oss.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author abliger
 */
@Slf4j
public class GetFile {
    public static String getFile(MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        String fileType = originalFilename.substring(originalFilename.indexOf("."));
        String format = new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
        UUID uuid = UUID.randomUUID();
        String fileName = format + uuid + fileType;
        log.debug(fileName);
        return fileName;
    }
}
