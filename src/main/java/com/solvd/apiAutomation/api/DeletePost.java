package com.solvd.apiAutomation.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/posts/${post_id}", methodType = HttpMethodType.GET)
public class DeletePost extends AbstractApiMethodV2 {
    public DeletePost(int postId) {
        replaceUrlPlaceholder("post_id", String.valueOf(postId));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
