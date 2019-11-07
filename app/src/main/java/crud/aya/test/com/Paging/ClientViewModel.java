package crud.aya.test.com.Paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;


public class ClientViewModel extends ViewModel {
    public LiveData<PagedList<Client>> userPagedList;
    private LiveData<ClientDataSource> liveDataSource;

    public ClientViewModel() {
        init();
    }

    private void init() {
        DataSourceFactory itemDataSourceFactory = new DataSourceFactory();

        liveDataSource = itemDataSourceFactory.userLiveDataSource;
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(ClientDataSource.PAGE_SIZE)
                .build();
        userPagedList = new LivePagedListBuilder<>(itemDataSourceFactory, config).build();
    }
}
