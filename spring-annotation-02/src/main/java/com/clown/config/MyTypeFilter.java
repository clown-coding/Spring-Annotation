package com.clown.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author: Richard·Ackerman
 * @create: 2019/2/9
 *
 * 自定义扫描规则
 **/
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader 读取到的当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前正在扫描的的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当前资源的路径信息
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        //System.out.println("+++++++"+className);
        if (className.contains("er")) {
            return true;
        }
        return false;
    }
}
