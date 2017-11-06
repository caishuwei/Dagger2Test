package com.csw.gagger2test.http;

import com.csw.gagger2test.entities.Repo;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by caisw on 2017/10/31.
 */

public interface GithubApiService {

    /**
     * 获取用户代码仓库列表
     *
     * @param user 用户编号
     * @return 仓库对象集合
     */
    @GET("/users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);

}
