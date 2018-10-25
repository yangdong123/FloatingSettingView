package com.sheng.preferencefloatingview.floating;

/**
 * Created by qietv on 2018/10/24.
 */
public class TaskModel {
    private String name;
    private String id;
    private String difficultyLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }
}
