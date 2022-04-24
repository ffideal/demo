package com.ffideal.spring.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

/**
 * @ClassName: MyTypeFilter
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/1/17 22:55
 * @Version: v1.0
 */

public class MyTypeFilter implements org.springframework.core.type.filter.TypeFilter {
    /**
     * 参数：
     * metadataReader：读取到的当前正在扫描的类的信息
     * metadataReaderFactory：可以获取到其他任何类的信息的（工厂）
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取正在扫描的类的类信息，比如说它的类型是什么，它实现了扫描接口等等
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类的资源信息，比如说类的路径等信息
        Resource resource = metadataReader.getResource();
        // 获取当前正在扫描的类名
        String className = classMetadata.getClassName();
        System.out.println("===>"+className);

        //现在制定一个规则。匹配成功就包含在容器中
        if(className.contains("Service")) return true;
        return false;   //先返回false
    }
}
