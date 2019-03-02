package com.forest.agvc.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Define Mybatis-plus configuration.
 * @author forestyang
 * @date 2019-02-27
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.wedo.agvc.datasource.mapper")
public class MybatisPlusConfig {

  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }

  /**
   * SQL执行效率插件.
   */
  @Bean
  @Profile({"test"})
  public PerformanceInterceptor performanceInterceptor() {
    return new PerformanceInterceptor();
  }
}
