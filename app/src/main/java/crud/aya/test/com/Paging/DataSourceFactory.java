package crud.aya.test.com.Paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class DataSourceFactory extends DataSource.Factory<Long, Client> {

        public MutableLiveData<ClientDataSource> userLiveDataSource=new MutableLiveData<>();

        @Override public DataSource<Long, Client> create() {
            ClientDataSource clientDataSource = new ClientDataSource();
            userLiveDataSource.postValue(clientDataSource);
            return clientDataSource;
        }
    }

