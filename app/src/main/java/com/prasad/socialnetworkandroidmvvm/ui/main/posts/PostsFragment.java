package com.prasad.socialnetworkandroidmvvm.ui.main.posts;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.prasad.socialnetworkandroidmvvm.R;
import com.prasad.socialnetworkandroidmvvm.ViewModelProviderFactory;
import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;
import com.prasad.socialnetworkandroidmvvm.databinding.FragmentPostsBinding;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import static com.prasad.socialnetworkandroidmvvm.BR.viewModel;

/**
 * Created By Prasad on 2020-05-25.
 */


public class PostsFragment extends BaseFragment<FragmentPostsBinding, PostsViewModel>
        implements PostsNavigator, PostsAdapter.PostsAdapterListener{

    @Inject
    PostsAdapter mPostsAdapter;
    FragmentPostsBinding mFragmentPostsBinding;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    ViewModelProviderFactory factory;
    public PostsViewModel mPostsViewModel;

    public static PostsFragment newInstance() {
        Bundle args = new Bundle();
        PostsFragment fragment = new PostsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return viewModel;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_posts;
    }


    @Override
    public PostsViewModel getViewModel() {
        mPostsViewModel = ViewModelProviders.of(this, factory).get(PostsViewModel.class);
        return mPostsViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPostsViewModel.setNavigator(this);
        mPostsAdapter.setListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentPostsBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentPostsBinding.postsRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentPostsBinding.postsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentPostsBinding.postsRecyclerView.setAdapter(mPostsAdapter);
    }

    @Override
    public void onRetryClick() {
        mPostsViewModel.fetchPosts(1);
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void updatePosts(List<PostsResponse.Posts> postsList) {
        mPostsAdapter.addItems(postsList);
    }
}
