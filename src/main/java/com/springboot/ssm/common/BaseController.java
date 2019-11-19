package com.springboot.ssm.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {

    public abstract IService<T> getIService();

    @GetMapping("/list")
    public List<T> list() {
        return getIService().list();
    }

    @GetMapping("/page")
    public IPage<T> page(@RequestParam long current, @RequestParam long size) {
        Page<T> page = new Page(current, size);
        return getIService().page(page);
    }

    @PostMapping("/add")
    public String add(@RequestBody T t) {
        return getIService().save(t) ? "添加成功！" : "添加失败！";
    }

    @PutMapping("/update")
    public String update(@RequestBody T t) {
        return getIService().updateById(t) ? "修改成功！" : "修改失败！";
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        return getIService().removeById(id) ? "删除成功！" : "删除失败！";
    }

}
