package com.gluuten.web;


import com.gluuten.domain.Person;
import com.gluuten.domain.Post;
import com.gluuten.domain.Title;
import com.gluuten.service.PersonService;
import com.gluuten.service.PostService;
import com.gluuten.service.TitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import java.util.List;

import static com.gluuten.configuration.Constants.URI_API_PREFIX;
import static com.gluuten.configuration.Constants.URI_POSTS;
import static com.gluuten.configuration.Constants.URI_TITLES;

/**
 * Created by yusufaslan on 3.06.2017.
 */
@RestController
@RequestMapping(value = URI_API_PREFIX)
public class TitleConroller {


    private static final Logger log = LoggerFactory.getLogger(TitleConroller.class);

    @Autowired
    private TitleService titleService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = URI_TITLES+"/save")
    public void titleSave(Title title)
    {
        titleService.createTitle(title);
    }

    @RequestMapping(value = URI_TITLES+"/update/{id}")
    public  void updateTitle(@PathVariable("id") Long id, Title title)
    {
        if (title.getId() == id)
        {
        titleService.updateTitle(title);
        }
    }

    @RequestMapping(value = URI_TITLES+"/delete/{id}")
    public void deleteTitle(@PathVariable("id") Long id)
    {
        titleService.deleteTitle(id);
    }

    @RequestMapping(value = URI_TITLES+"/allTitles")
    public List<Title> allTitles()
    {
        return titleService.getTitlesOrderByDate();
    }

    @RequestMapping(value = URI_TITLES+"/getTitle/{id}") //the response was empty
    public Title getTitle(@PathParam("id")Long id,Person person)
    {
      return titleService.getTitleById(id);
    }


}
