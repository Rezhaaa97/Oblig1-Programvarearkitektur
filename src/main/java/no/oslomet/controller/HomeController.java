package no.oslomet.controller;

import no.oslomet.model.Author;
import no.oslomet.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SessionFactory sessionFactory;

    List<Author> authorList = new LinkedList<Author>();
    List<Book> bookList = new LinkedList<Book>();

    @GetMapping("/")
    @Transactional
    public String home(){
        return "index";
    }

    @GetMapping("/listAuthor")
    @Transactional
    public String listAuthor(Model model){
        List<Author> author= getAllAuthor();
        model.addAttribute("authors",author);
        return "listAuthor";
    }
    @GetMapping("/listBook")
    @Transactional
    public String listBook(Model model){
        List<Book> book = getAllBook();
        model.addAttribute("books", book);
        return "listBook";
    }

    @GetMapping("/authorForm")
    @Transactional
    public String formAuthor(Model model){
        Author author = new Author();
        model.addAttribute("author",author);
        return "authorForm";
    }

    @GetMapping("/formBook")
    @Transactional
    public String formBook(Model model){
        Book book = new Book();
        model.addAttribute("authors", getAllAuthor());
        model.addAttribute("book", book);
        return "formBook";
    }

    /*
    @PostMapping("/saveAuthor")
    @Transactional
    public String saveA(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName, @RequestParam("nationality") String nationality ){
        Author author = new Author();
        author.setId(authorList.size() +1);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setNationality(nationality);
        authorList.add(author);
        return "redirect:/listAuthor";
    }
    */
    @PostMapping("/saveAuthor")
    @Transactional
    public String saveAuth(@ModelAttribute("author") Author auth){
       // Author author = new Author(auth.getId(),auth.getFirstName(),auth.getLastName(),auth.getNationality());
        saveAuthor(auth);
        return "redirect:/listAuthor";
    }


    @PostMapping("/save")
    @Transactional
    public String save(@RequestParam("ISBN") String ISBN,   @RequestParam("author") String idParam,
                       @RequestParam("title") String title, @RequestParam("releaseYear") String rYear){

        Book book = new Book();
        book.setISBN(Long.parseLong(ISBN));
        book.setTitle(title);
        book.setReleaseYear(rYear);
        book.setAuthor(getAuthorById(Long.parseLong(idParam)));
        saveBook(book);
        return "redirect:/listBook";
    }

    @GetMapping("/edit/{id}")
    @Transactional
    public String editBook(@PathVariable("id") String idParam, Model model){


        model.addAttribute("book", getBookByISBN(Long.parseLong(idParam)));
        model.addAttribute("authors", getAllAuthor());
        return "formBook";

    }


    @GetMapping("/delete/{id}")
    @Transactional
    public String deleteBook(@PathVariable("id") String isbnParma, Model model){
      deleteBook(getBookByISBN(Long.parseLong(isbnParma)));

        return "redirect:/listBook";
    }

    //Hibernate CRUD Methods


    public void saveAuthor(Author author){
        sessionFactory.getCurrentSession().saveOrUpdate(author);
    }

    public List<Author> getAllAuthor(){
        return sessionFactory.getCurrentSession().createCriteria(Author.class).list();
    }

    public void saveBook(Book book){
        sessionFactory.getCurrentSession().saveOrUpdate(book);
    }

    public List<Book> getAllBook(){
        return sessionFactory.getCurrentSession().createCriteria(Book.class).list();
    }

    public void updateBook(Book book){
        sessionFactory.getCurrentSession().update(book);
    }
    public void deleteBook(Book book){
        sessionFactory.getCurrentSession().delete(book);
    }

    public Book getBookByISBN(long ISBN){
        return sessionFactory.getCurrentSession().find(Book.class, ISBN);
    }

    public Author getAuthorById(long id){
        return sessionFactory.getCurrentSession().find(Author.class, id);
    }




}
