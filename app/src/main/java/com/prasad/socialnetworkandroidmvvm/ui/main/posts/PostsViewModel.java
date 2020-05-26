package com.prasad.socialnetworkandroidmvvm.ui.main.posts;

import androidx.lifecycle.MutableLiveData;

import com.prasad.socialnetworkandroidmvvm.data.DataManager;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsRequest;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;
import com.prasad.socialnetworkandroidmvvm.data.remote.SocialNetworkService;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseViewModel;
import com.prasad.socialnetworkandroidmvvm.utils.rx.SchedulerProvider;

import java.util.List;

/**
 * Created By Prasad on 2020-05-25.
 */


public class PostsViewModel extends BaseViewModel<PostsNavigator> {

    private final MutableLiveData<List<PostsResponse.Posts>> postsListLiveData;

    public PostsViewModel(SocialNetworkService networkService, DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(networkService, dataManager, schedulerProvider);
        postsListLiveData = new MutableLiveData<>();
        fetchPosts(1);
    }

    public void fetchPosts(int page) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getPostsApiCall(new PostsRequest(page))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(postsResponse -> {

                    if (postsResponse != null && postsResponse.getResult() != null) {
                        postsListLiveData.setValue(postsResponse.getResult());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public MutableLiveData<List<PostsResponse.Posts>> getPostsListLiveData() {
        return postsListLiveData;
    }
}
