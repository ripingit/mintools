package com.atecher.mintools.web.controller;

import com.atecher.mintools.mapper.SearchMapper;
import com.atecher.mintools.web.util.WebForwardConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hanhongwei on 2016/7/19.
 */
@Controller
public class SearchController {

    @Autowired
    private SearchMapper searchMapper;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String js(@RequestParam(value = "s", required = false) String search, Model model) {
        List<HashMap<String, Object>> tools = null;
        if (!StringUtils.isEmpty(search)) {
            tools = searchMapper.search(search);
        }
        model.addAttribute("tools", tools);
        return WebForwardConstants.INDEX;
    }


}
