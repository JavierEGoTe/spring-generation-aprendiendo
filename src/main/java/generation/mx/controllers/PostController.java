package generation.mx.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.mx.models.PostModel;
import generation.mx.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
    PostService postService;

    @GetMapping
    public ArrayList<PostModel> getPosts(){
        return postService.getPost();
    }

    @PostMapping
    public PostModel savePost(@RequestBody PostModel post) {
        return postService.savePost(post);
    }

    @GetMapping(path="/{id}")
    public Optional<PostModel> getPostById(@PathVariable("id") Long id){
        return postService.getPostById(id);
    }

    @GetMapping(path="/query")
    public ArrayList<PostModel> getPostByTitle(@RequestParam(value= "title", defaultValue="") String title){
        return postService.getPostByTitle(title);
    }

    @GetMapping(path="/q")
    public ArrayList<PostModel> getPostByTitleOrderById(@RequestParam(value= "title", defaultValue="") String title){
        return postService.getPostByTitleContainingDesc(title);
    }
}
