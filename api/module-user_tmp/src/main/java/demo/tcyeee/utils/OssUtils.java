package demo.tcyeee.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里OSS工具类
 *
 * @author tcyeee
 * @date 2020/1/10 14:51
 */
public final class OssUtils {

    /* 基础配置信息 */
    private static final String END_POINT = "";
    private static final String ACCESS_KEY_ID = "";
    private static final String ACCESS_KEY_SECRET = "";
    private static final String BUCKET_NAME = "";

    /* 文件夹分类 */
    private final static String DIR_COMMON = "common/";


    /**
     * 上传文件
     *
     * @param file 文件
     */
    public static String putFile(MultipartFile file) {
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        String fileName = getFileName();
        String fileType = file.getContentType();
        String oldName = file.getOriginalFilename();

        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(BUCKET_NAME, DIR_COMMON + fileName, inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }


    /**
     * 获取图片url
     *
     * @param fileName fileName
     * @return img url
     */
    public static String getUrl(String fileName) {
        String tmp = "https://%s.%s/%s%s";
        return String.format(tmp, BUCKET_NAME, END_POINT, DIR_COMMON, fileName);
    }


    /**
     * 获取图片url
     *
     * @param fileName fileName
     * @param folder   folderName
     * @return img url
     */
    public static String getUrl(String fileName, String folder) {
        String tmp = "https://%s.%s/%s%s";
        return String.format(tmp, BUCKET_NAME, END_POINT, folder, fileName);
    }


    /**
     * 生成OSS key
     *
     * @return oss key
     */
    private static String getFileName() {
        return UUID.randomUUID().toString();
    }
}
