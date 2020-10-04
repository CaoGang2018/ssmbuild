package com.cao.controller;

import com.cao.pojo.Books;
import com.cao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author admin_cg
 * @data 2020/10/3 16:41
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部书籍，返回到书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    // 跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    // 添加书籍的请求
    @RequestMapping("/addBook")
    public String  addBook(Books books){
        System.out.println("addBook=>" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook"; // 重定向到@RequestMapping("/allBook")
    }

    // 跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id, Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook", books);
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>" + books);
        bookService.updateBook(books);
        return "redirect:/book/allBook"; // 重定向到@RequestMapping("/allBook")
    }

    // 删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBookById(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook"; // 重定向到@RequestMapping("/allBook")
    }

    // 查询
    @RequestMapping("/queryBook")
    public String queryBook (String queryBookName, Model model) {
        System.out.println(queryBookName.length());
        List<Books> list;
        if(queryBookName.trim().length() == 0){
            list = bookService.queryAllBook();
            model.addAttribute("errorInfo", "查询到 0 条记录！");
            model.addAttribute("successInfo", "");
        }
        else {
            list = bookService.queryBookByName(queryBookName.trim());
            model.addAttribute("errorInfo", "");
            model.addAttribute("successInfo", "查询到 " + list.size() + " 条记录！");
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
