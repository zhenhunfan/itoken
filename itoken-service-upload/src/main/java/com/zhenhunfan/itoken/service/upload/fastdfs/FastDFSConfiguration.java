package com.zhenhunfan.itoken.service.upload.fastdfs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * <p>Title: FastDFSConfiguration</p>
 * <p>Description: Java 配置方式定义 StorageFactory 的 Bean 使其可以被依赖注入</p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/24
 */
@Configuration
public class FastDFSConfiguration {
    @Bean
    public StorageFactory storageFactory() {
        return new StorageFactory();
    }
}
