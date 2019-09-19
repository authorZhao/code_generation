package com.git.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.git.service.ORoleService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/o-role")
public class ORoleController {
    private final Logger logger = LoggerFactory.getLogger(ORoleController.class);

    @Autowired
    private ORoleService oRoleService;


}

