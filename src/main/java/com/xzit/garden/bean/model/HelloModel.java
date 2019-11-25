package com.xzit.garden.bean.model;

import javax.validation.constraints.NotNull;

public class HelloModel {
    @NotNull(message = "名称不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
