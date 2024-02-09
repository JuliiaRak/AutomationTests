package com.solvd.apiAutomation.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/posts/${post_id}", methodType = HttpMethodType.PUT)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@RequestTemplatePath(path = "api/posts/update_post_rq.json")
@ResponseTemplatePath(path = "api/posts/update_post_rs.json")
public class UpdatePost extends AbstractApiMethodV2 {
    public UpdatePost(int postId) {
        replaceUrlPlaceholder("post_id", String.valueOf(postId));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
