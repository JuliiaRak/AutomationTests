package com.solvd.apiAutomation.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/posts/${post_id}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeletePost extends AbstractApiMethodV2 {
    public DeletePost(int postId) {
        replaceUrlPlaceholder("post_id", String.valueOf(postId));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
