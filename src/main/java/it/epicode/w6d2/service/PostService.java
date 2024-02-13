package it.epicode.w6d2.service;

import it.epicode.w6d2.model.Autore;
import it.epicode.w6d2.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {
    private List<Post> posts = new ArrayList<>();

    @Autowired
    AutoreService autoreService;

    public List<Post> cercaTuttiPost(){
        return posts;
    }

    public Post cercaPostPerId(int id) throws NoSuchElementException {
        Optional<Post> a = posts.stream().filter(post ->post.getId()==id).findAny();

        if (a.isPresent()){
            return a.get();
        }
        else {
            throw new NoSuchElementException("Autore non trovato");
        }
    }

    public void salvaPost(Post post) throws NoSuchElementException{
        if (post.getAutore()==null){
            throw new NoSuchElementException("Inserire un autore");
        }
        posts.add(post);
    }

    public Post aggiornaPost(int id, Post post){
        Post p = cercaPostPerId(id);

        p.setCategoria(post.getCategoria());
        p.setTitolo(post.getTitolo());
        p.setContenuto(post.getContenuto());
        p.setCover(post.getCover());
        p.setTempoDiLettura(post.getTempoDiLettura());

        return p;
    }

    public void eliminaPost(int id){
        Post p = cercaPostPerId(id);
        posts.remove(p);
    }
}
