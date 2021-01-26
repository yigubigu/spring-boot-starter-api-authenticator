package com.ruize.api.authenticator.sample.controller;

import com.ruize.api.authenticator.ApiRequest;
import com.ruize.api.authenticator.sample.model.Book;
import com.ruize.api.authenticator.service.ApiAuthencator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/books")
public class BookController {


    @GetMapping
    public List<Book> getAllBooks(final ServletRequest request) {

        return
        Arrays.asList(
                    new Book("book1", "auth1"),
                    new Book("book2", "auth1")
                );

    }
}
