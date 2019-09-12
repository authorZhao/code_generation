package com.git.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.git.service.OBlogService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 博客 前端控制器
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-12
 */
@RestController
@RequestMapping("/o-blog")
public class OBlogController {
    private final Logger logger = LoggerFactory.getLogger(OBlogController.class);

    @Autowired
    private OBlogService oBlogService;


}

