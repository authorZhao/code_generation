package com.git.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.git.service.OUserService;

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
@RequestMapping("/o-user")
public class OUserController {
    private final Logger logger = LoggerFactory.getLogger(OUserController.class);

    @Autowired
    private OUserService oUserService;


}

