package com.southsystem.desafiobackvotos.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController("AssociateController")
@RequestMapping(RestPath.BASE_PATH + "/associates")
@Api(tags = "Associates")
public class AssociateController {
}
