package com.gluuten.web;

import com.gluuten.domain.Post;
import com.gluuten.service.CommentService;
import com.gluuten.service.PostService;
import com.gluuten.service.TitleService;
import javafx.geometry.Pos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import java.util.List;

import static com.gluuten.configuration.Constants.URI_API_PREFIX;
import static com.gluuten.configuration.Constants.URI_COMMENTS;
import static com.gluuten.configuration.Constants.URI_POSTS;

/**
 * Created by yusufaslan on 3.06.2017.
 */
@RestController
@RequestMapping(value = URI_API_PREFIX)
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private TitleService titleService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = URI_POSTS+"/save")
    public void savePost(Post post)
    {
        postService.savePost(post);
    }

    @RequestMapping(value = URI_POSTS+"/update")
    public void updatePost(Post post)
    {
        postService.updatePost(post);
    }

    @RequestMapping(value = URI_POSTS+"/delete/{id}")
    public void deletePost(@PathVariable("id")Long id)
    {
        postService.deletePost(id);
    }

    @RequestMapping(value = URI_POSTS+"/postOfTitle/{id}")//bu id title'ın id sidir. post_title_id si buna eşit olanları getireceğiz.
    public List<Post> getPostOfTitle(@PathVariable("id")Long id)
    {
       return postService.findByPostTitleOrderByPostDate(id);
    }

    @RequestMapping(value = URI_POSTS+"/postOrPerson/{id}")//bu id person'ın id sidir. post_sender_id si buna eşit olanları getireceğiz.
    public List<Post> getPostOfPerson(@PathVariable("id")Long id)
    {
        return postService.getPostsByPerson(id);
    }
    @RequestMapping(value = URI_POSTS+"/getPost/{id}")
    public Post getPostById(@PathVariable("id")Long id)
    {
        return postService.getPostById(id);
    }






}
