package com.example.demo;

import java.io.Serializable;
import java.util.List;

public class SerialBean  implements Serializable {
    private List<List<Object>> list;

    public List<List<Object>> getList() {
        return list;
    }

    public void setList(List<List<Object>> list) {
        this.list = list;
    }
}
