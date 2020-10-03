package com.cao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin_cg
 * @data 2020/10/3 15:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private int bookId;
    private String bookNme;
    private int bookCounts;
    private String detail;
}
