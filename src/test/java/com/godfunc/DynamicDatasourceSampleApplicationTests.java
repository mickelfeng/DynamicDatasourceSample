package com.godfunc;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.godfunc.entity.Dict;
import com.godfunc.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class DynamicDatasourceSampleApplicationTests {

    @Autowired
    private DictService dictService;

    @Test
    @DSTransactional
    void contextLoads() {
        try {
            List<Dict> list = dictService.list();
            log.info("result master list {}", list);
            DynamicDataSourceContextHolder.push("sla");
            List<Dict> list1 = dictService.list();
            log.info("result sla list {}", list1);
        } finally {
            DynamicDataSourceContextHolder.clear();
        }
    }

}
