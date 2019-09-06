package apiTest;

import apiModels.Teacher;

import java.util.List;

public class MyResponse {

    private List<Teacher> teachers;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
