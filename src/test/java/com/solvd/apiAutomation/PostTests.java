package com.solvd.apiAutomation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.solvd.apiAutomation.api.*;
import com.solvd.apiAutomation.domain.Post;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class PostTests {

    @Test
    public void verifyGetPostById() {
        Post post = new Post();
        post.setId(3);
        post.setUserId(1);
        post.setTitle("ea molestias quasi exercitationem repellat qui ipsa sit aut");
        post.setBody("et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut");

        GetPostById getPostById = new GetPostById(post.getId());
        getPostById.addProperty("post", post);

        getPostById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPostById.callAPIExpectSuccess();
        getPostById.validateResponse();
    }

    @Test
    public void verifyGetPostByIdNotFound() {
        Post post = new Post();
        post.setId(101);

        GetPostById getPostById = new GetPostById(post.getId());

        getPostById.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getPostById.callAPI();
    }

    @Test
    public void verifyCreatePost() {
        Post post = new Post();
        post.setTitle("New post");
        post.setBody("It is my first post");
        post.setUserId(1);

        CreatePost createPost = new CreatePost();
        createPost.addProperty("post", post);

        createPost.callAPIExpectSuccess();
    }

    @Test
    public void verifyCreatePostWithMapper() {
        Post post = new Post();
        post.setTitle("New post");
        post.setBody("It is my first post");
        post.setUserId(1);

        try {
            CreatePostWithMapper createPostWithMapper = new CreatePostWithMapper(post);
            createPostWithMapper.expectResponseStatus(HttpResponseStatusType.CREATED_201);
            createPostWithMapper.callAPI();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyUpdatePost() {
        Post post = new Post();
        post.setId(1);
        post.setTitle("New post updated");
        post.setBody("It is my updated post");
        post.setUserId(1);

        UpdatePost updatePost = new UpdatePost(post.getId());
        updatePost.addProperty("post", post);

        updatePost.callAPIExpectSuccess();
    }

    @Test
    public void verifyDeletePost() {
        Post post = new Post();
        post.setId(3);

        DeletePost deletePost = new DeletePost(post.getId());

        deletePost.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePost.callAPI();
    }
}
