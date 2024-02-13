package it.epicode.w6d2.controller;

import it.epicode.w6d2.model.Post;
import it.epicode.w6d2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getAll(){
        return postService.cercaTuttiPost();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id){
        return postService.cercaPostPerId(id);
    }

    @PostMapping("")
    public void savePost(@RequestBody Post post){
        postService.salvaPost(post);
    }

    @PutMapping("/{id}")
    public void modifyPost(@PathVariable int id, @RequestBody Post post){
        postService.aggiornaPost(id,post);
    }
    
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){
        postService.eliminaPost(id);
    }

}
