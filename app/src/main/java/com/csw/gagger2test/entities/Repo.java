package com.csw.gagger2test.entities;

/**
 * Github用户代码仓库
 * Created by caisw on 2017/10/31.
 */

public class Repo {

    private String name; // 库的名字
    private String description; // 描述
    private String language; // 语言

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
