package com.codingwithmitch.daggerpractice.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingwithmitch.daggerpractice.R;
import com.codingwithmitch.daggerpractice.models.Post;
import com.codingwithmitch.daggerpractice.ui.main.Resource;
import com.codingwithmitch.daggerpractice.util.VerticalSpaceItemDecoration;
import com.codingwithmitch.daggerpractice.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerFragment;
import io.reactivex.disposables.Disposable;

public class PostsFragment extends DaggerFragment {

    private static final String TAG = "PostsFragment";

    private PostsViewModel viewModel;
    private RecyclerView recyclerView;

    @Inject
    PostRecyclerAdapter adapter;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: PostsFragment created... " + this);
        recyclerView = view.findViewById(R.id.recycler_view);

        viewModel = ViewModelProviders.of(this, providerFactory).get(PostsViewModel.class);

        initRecyclerView();
        subscribeObservers();
    }

    private void subscribeObservers(){
        viewModel.observePosts().removeObservers(getViewLifecycleOwner());
        viewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if(listResource != null){
                    switch (listResource.status){
                        case LOADING:{
                            Log.d(TAG, "onChanged: PostsFragment: LOADING...");
                            break;
                        }

                        case SUCCESS:{
                            Log.d(TAG, "onChanged: PostsFragment: got posts.");
                            adapter.setPosts(listResource.data);
                            break;
                        }

                        case ERROR:{
                            Log.d(TAG, "onChanged: PostsFragment: ERROR... " + listResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VerticalSpaceItemDecoration itemDecoration = new VerticalSpaceItemDecoration(15);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
    }

}






















