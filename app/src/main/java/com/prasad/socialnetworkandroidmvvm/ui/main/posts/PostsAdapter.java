package com.prasad.socialnetworkandroidmvvm.ui.main.posts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prasad.socialnetworkandroidmvvm.data.model.api.PostsResponse;
import com.prasad.socialnetworkandroidmvvm.databinding.ItemPostEmptyViewBinding;
import com.prasad.socialnetworkandroidmvvm.databinding.ItemPostViewBinding;
import com.prasad.socialnetworkandroidmvvm.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created By Prasad on 2020-05-26.
 */


public class PostsAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<PostsResponse.Posts> mPostsResponseList;

    private PostsAdapterListener mListener;

    public PostsAdapter(List<PostsResponse.Posts> postsResponseList){
        this.mPostsResponseList = postsResponseList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemPostViewBinding postsViewBinding = ItemPostViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new PostsViewHolder(postsViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemPostEmptyViewBinding emptyViewBinding = ItemPostEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mPostsResponseList != null && mPostsResponseList.size() > 0) {
            return mPostsResponseList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mPostsResponseList != null && !mPostsResponseList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public void addItems(List<PostsResponse.Posts> postsList) {
        mPostsResponseList.addAll(postsList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mPostsResponseList.clear();
    }

    public void setListener(PostsAdapterListener listener) {
        this.mListener = listener;
    }

    public interface PostsAdapterListener {
        void onRetryClick();
    }

    public class PostsViewHolder extends BaseViewHolder implements PostsItemViewModel.PostsItemViewModelListener{
        private final ItemPostViewBinding mBinding;

        private PostsItemViewModel mPostsItemViewModel;

        public PostsViewHolder(ItemPostViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final PostsResponse.Posts post = mPostsResponseList.get(position);
            mPostsItemViewModel = new PostsItemViewModel(post, this);
            mBinding.setViewModel(mPostsItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick() {

        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements PostsEmptyItemViewModel.PostsEmptyItemViewModelListener {

        private ItemPostEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemPostEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            PostsEmptyItemViewModel emptyItemViewModel = new PostsEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }
}
