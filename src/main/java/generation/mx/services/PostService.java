package generation.mx.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.mx.models.PostModel;
import generation.mx.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public ArrayList<PostModel> getPost(){
		return (ArrayList<PostModel>) postRepository.findAll();
	}
	
	public PostModel savePost(PostModel post) {
		return postRepository.save(post);
	}
	
	public Optional<PostModel> getPostById(long id){
		return postRepository.findById(id);
	}
	
	public ArrayList <PostModel> getPostByTitle(String title){
		return postRepository.findByTitleContaining(title);
	}
	public ArrayList<PostModel> getPostByTitleContainingDesc(String title){
		return postRepository.findByTitleContainingOrderByIdDesc(title);
	}
	
}
