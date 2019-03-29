package cn.elmi.sample.mybatis.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @version 1.0
 * @authur Arthur
 */

@EnableTransactionManagement
@MapperScan("cn.elmi.sample.mybatis.mapper")
@AutoConfigureAfter({DataSourceAutoConfiguration.class})
@AutoConfigureBefore(MybatisAutoConfiguration.class)
public class DataAutoConfiguration {

}
