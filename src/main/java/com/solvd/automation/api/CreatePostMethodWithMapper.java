package com.solvd.automation.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.automation.domain.Post;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/posts", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
@ResponseTemplatePath(path = "api/posts/create_post_rs.json")
public class CreatePostMethodWithMapper extends AbstractApiMethodV2 {
    public CreatePostMethodWithMapper(Post post) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        super.setBodyContent(objectMapper.writeValueAsString(post));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
