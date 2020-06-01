package com.southsystem.desafiobackvotos.service.vo;

import java.util.List;

public class ScoreCloseListVO {

    private List<String> scoresToCloseList;

    public List<String> getScoresToCloseList() {
        return scoresToCloseList;
    }

    public ScoreCloseListVO setScoresToCloseList(List<String> scoresToCloseList) {
        this.scoresToCloseList = scoresToCloseList;
        return this;
    }
}
