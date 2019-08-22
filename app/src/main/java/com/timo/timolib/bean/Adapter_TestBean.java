package com.timo.timolib.bean;

/**
 * Created by 蔡永汪 on 2019/8/22.
 */

public class Adapter_TestBean {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adapter_TestBean(String name) {
        this.name = name;
    }

    private String name;
}
