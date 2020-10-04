package com.senyint.exercise.vo.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: PageVO
 * TODO:类文件简单描述
 * @Author: lidekun
 * @UpdateUser: lidekun
 * @Version: 0.0.1
 */
@Data
public class PageVO<T> {
    @ApiModelProperty(value = "总记录数")
    private Long totalRows;
    @ApiModelProperty(value = "分页列表数据")
    private List<T> list;
    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private Integer totalPages;

    /**
     * 当前第几页
     */
    @ApiModelProperty(value = "当前第几页")
    private Integer pageNum;
    /**
     * 每页记录数
     */
    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;
    /**
     * 当前页记录数
     */
    @ApiModelProperty(value = "当前页记录数")
    private Integer curPageSize;
}
