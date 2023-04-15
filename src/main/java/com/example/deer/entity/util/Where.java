package com.example.deer.entity.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.HashMap;

public class Where<T> {

    private Page<T> page = new Page();
    private HashMap<String, Object> where = new HashMap();

    public Page<T> getPage() {
        return this.page;
    }
    public HashMap<String, Object> getWhere() {
        return this.where;
    }


}
