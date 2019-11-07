package crud.aya.test.com.Paging;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import crud.aya.test.com.R;

public class DataActivity extends AppCompatActivity {
 RecyclerView recyclerView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recycler_view);

    recyclerView = findViewById(R.id.recyclerView);

    final ClientAdapter adapter = new ClientAdapter();

    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    ClientViewModel itemViewModel = ViewModelProviders.of(this).get(ClientViewModel.class);
    itemViewModel.userPagedList.observe(this, new Observer<PagedList<Client>>() {
      @Override public void onChanged(PagedList<Client> users) {
        adapter.submitList(users);
      }
    });
    recyclerView.setAdapter(adapter);
  }
  }
