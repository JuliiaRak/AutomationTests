package com.solvd.apiAutomation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.solvd.apiAutomation.api.*;
import com.solvd.apiAutomation.domain.Post;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class ApiPostTests {

    @Test
    public void verifyGetExactPostByIdCorrectTest() {
        Post post = new Post();
        post.setId(3);
        post.setUserId(1);
        post.setTitle("ea molestias quasi exercitationem repellat qui ipsa sit aut");
        post.setBody("et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut");

        GetPostByIdMethod getPostById = new GetPostByIdMethod(post.getId());
        getPostById.addProperty("post", post);

        getPostById.callAPIExpectSuccess();
        getPostById.validateResponse();
    }

    @Test
    public void verifyGetPostByIdInCorrectTest() {
        Post post = new Post();
        post.setId(101);

        GetPostByIdMethod getPostById = new GetPostByIdMethod(post.getId());

        getPostById.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getPostById.callAPI();
    }

    @Test
    public void verifyCreatePostTest() {
        Post post = new Post();
        post.setTitle("New post");
        post.setBody("It is my first post");
        post.setUserId(1);

        CreatePostMethod createPost = new CreatePostMethod();
        createPost.addProperty("post", post);

        createPost.callAPIExpectSuccess();
        createPost.validateResponse();
    }

    @Test
    public void verifyCreatePostWithMapperTest() {
        try {
            Post post = new Post();
            post.setTitle("New post");
            post.setBody("It is my first post");
            post.setUserId(1);
            CreatePostMethodWithMapper createPostWithMapper = new CreatePostMethodWithMapper(post);
            createPostWithMapper.callAPIExpectSuccess();

            createPostWithMapper.addProperty("post", post);
            createPostWithMapper.validateResponse();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void verifyUpdatePostTest() {
        Post post = new Post();
        post.setId(1);
        post.setTitle("New post updated");
        post.setBody("It is my updated post");
        post.setUserId(1);

        UpdatePostMethod updatePost = new UpdatePostMethod(post.getId());
        updatePost.addProperty("post", post);

        updatePost.callAPIExpectSuccess();
        updatePost.validateResponse();
    }

    @Test
    public void verifyDeletePostTest() {
        Post post = new Post();
        post.setId(3);

        DeletePostMethod deletePost = new DeletePostMethod(post.getId());
        deletePost.callAPIExpectSuccess();
    }
}
