package com.southsystem.desafiobackvotos.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController("ScoreController")
@RequestMapping(RestPath.BASE_PATH + "/scores")
@Api(tags = "Scores")
public class ScoreController {
}
