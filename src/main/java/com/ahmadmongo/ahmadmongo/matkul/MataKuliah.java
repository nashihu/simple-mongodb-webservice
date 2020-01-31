package com.ahmadmongo.ahmadmongo.matkul;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matkul")
public class MataKuliah {

    @Id
    private String id;
    private String name;
    private String teacherName;
    private int SKS;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getSKS() {
        return SKS;
    }

    public void setSKS(int SKS) {
        this.SKS = SKS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MataKuliah(String id, String name, String teacherName, int SKS) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
        this.SKS = SKS;
    }
}
