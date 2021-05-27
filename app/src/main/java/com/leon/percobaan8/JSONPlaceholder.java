package com.leon.percobaan8;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface JSONPlaceholder {
    @GET("posts")
    Call<List<Post>> getPost();

    @GET("posts/{id}/comments")
    Call<List<Post_Detail>> getcomments(@Path("id") String id);

}
