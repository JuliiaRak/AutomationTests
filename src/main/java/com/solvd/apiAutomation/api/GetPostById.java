package com.solvd.apiAutomation.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/posts/${post_id}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@ResponseTemplatePath(path = "api/posts/get_post_rs.json")
public class GetPostById extends AbstractApiMethodV2 {
    public GetPostById(int postId) {
        replaceUrlPlaceholder("post_id", String.valueOf(postId));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
