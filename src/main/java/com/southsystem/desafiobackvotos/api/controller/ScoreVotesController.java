package com.southsystem.desafiobackvotos.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController("ScoreVotesController")
@RequestMapping(RestPath.BASE_PATH + "/score-votes")
@Api(tags = "Score Votes")
public class ScoreVotesController {
}
