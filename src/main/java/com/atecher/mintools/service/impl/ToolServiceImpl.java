package com.atecher.mintools.service.impl;

import com.atecher.mintools.mapper.ToolMapper;
import com.atecher.mintools.service.IToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: hanhongwei
 * @Description:
 * @Date: Created on 2017/12/13
 */

@Service
public class ToolServiceImpl implements IToolService {
    @Autowired
    private ToolMapper toolMapper;
    @Cacheable(value = {"caffeineMintoolsCache"}, key = "#root.targetClass + #root.methodName")
    @Override
    public List<HashMap<String, Object>> findToolAll() {
        return toolMapper.findToolAll();
    }
    @Cacheable(value = {"caffeineMintoolsCache"}, key = "#root.targetClass + #root.methodName + #param")
    @Override
    public List<HashMap<String, Object>> findToolsByCategory(String param) {
        return toolMapper.findToolsByCategory(param);
    }
}
