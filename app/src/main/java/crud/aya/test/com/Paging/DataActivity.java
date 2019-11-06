package crud.aya.test.com.Paging;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/*
public class DataActivity extends AppCompatActivity {

        private FeedListAdapter adapter;
        private FeedViewModel feedViewModel;
        private FeedActivityBinding binding;

    @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            /*
             * Step 1: Using DataBinding, we setup the layout for the activity
             *
             * */
  //          binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

            /*
             * Step 2: Initialize the ViewModel
             *
             * */
    //        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel.class);

            /*
             * Step 2: Setup the adapter class for the RecyclerView
             *
             * */
      //      binding.listFeed.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
      //      adapter = new FeedListAdapter(getApplicationContext());


            /*
             * Step 4: When a new page is available, we call submitList() method
             * of the PagedListAdapter class
             *
             * */
    /*
            feedViewModel.getArticleLiveData().observe(this, pagedList -> {
                adapter.submitList(pagedList);
            });

            feedViewModel.getNetworkState().observe(this, networkState -> {
                adapter.setNetworkState(networkState);
            });

            binding.listFeed.setAdapter(adapter);
        }

}
*/