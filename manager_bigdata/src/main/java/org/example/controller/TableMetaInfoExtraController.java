package org.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.TableMetaInfoExtra;
import org.example.service.TableMetaInfoExtraService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 元数据表附加信息(TableMetaInfoExtra)表控制层
 *
 * @author makejava
 * @since 2023-06-05 15:30:39
 */
@RestController
@RequestMapping("tableMetaInfoExtra")
public class TableMetaInfoExtraController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TableMetaInfoExtraService tableMetaInfoExtraService;
    @PostMapping("/init-tables/{database}")


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tableMetaInfoExtra 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TableMetaInfoExtra> page, TableMetaInfoExtra tableMetaInfoExtra) {
        return success(this.tableMetaInfoExtraService.page(page, new QueryWrapper<>(tableMetaInfoExtra)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tableMetaInfoExtraService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tableMetaInfoExtra 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TableMetaInfoExtra tableMetaInfoExtra) {
        return success(this.tableMetaInfoExtraService.save(tableMetaInfoExtra));
    }

    /**
     * 修改数据
     *
     * @param tableMetaInfoExtra 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TableMetaInfoExtra tableMetaInfoExtra) {
        return success(this.tableMetaInfoExtraService.updateById(tableMetaInfoExtra));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tableMetaInfoExtraService.removeByIds(idList));
    }
}

