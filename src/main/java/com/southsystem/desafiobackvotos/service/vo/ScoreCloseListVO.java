package com.southsystem.desafiobackvotos.service.vo;

import java.io.Serializable;
import java.util.List;

public class ScoreCloseListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> scoresToCloseList;

    public List<String> getScoresToCloseList() {
        return scoresToCloseList;
    }

    public ScoreCloseListVO setScoresToCloseList(List<String> scoresToCloseList) {
        this.scoresToCloseList = scoresToCloseList;
        return this;
    }
}
