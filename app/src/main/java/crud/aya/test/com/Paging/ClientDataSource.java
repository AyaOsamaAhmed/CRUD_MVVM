package crud.aya.test.com.Paging;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientDataSource extends PageKeyedDataSource<Long, Client> {
    public static int PAGE_SIZE = 6;
    public static long FIRST_PAGE = 1;
    @Override public void loadInitial(@NonNull final LoadInitialParams<Long> params,
                                      @NonNull final LoadInitialCallback<Long, Client> callback) {
        RestApi service = Retroft.buildService(RestApi.class);
        Call<ClientResponse> call = service.getUsers(FIRST_PAGE);
        call.enqueue(new Callback<ClientResponse>() {
            @Override public void onResponse(Call<ClientResponse> call, Response<ClientResponse> response) {
                ClientResponse apiResponse = response.body();
                if (apiResponse != null) {
                    List<Client> responseItems = apiResponse.getUsers();
                    callback.onResult(responseItems, null, FIRST_PAGE + 1);
                }
            }
            @Override public void onFailure(Call<ClientResponse> call, Throwable t) {
            }
        });
    }
    @Override
    public void loadBefore(@NonNull final LoadParams<Long> params,
                           @NonNull final LoadCallback<Long, Client> callback) {
        RestApi apiService = Retroft.buildService(RestApi.class);
        Call<ClientResponse> call = apiService.getUsers(params.key);
        call.enqueue(new Callback<ClientResponse>() {
            @Override public void onResponse(Call<ClientResponse> call, Response<ClientResponse> response) {
                ClientResponse apiResponse = response.body();
                if (apiResponse != null) {
                    List<Client> responseItems = apiResponse.getUsers();
                    long key;
                    if (params.key > 1) {
                        key = params.key - 1;
                    } else {
                        key = 0;
                    }
                    callback.onResult(responseItems, key);
                }
            }
            @Override public void onFailure(Call<ClientResponse> call, Throwable t) {
            }
        });
    }
    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params,
                          @NonNull final LoadCallback<Long, Client> callback) {
        RestApi service = Retroft.buildService(RestApi.class);
        Call<ClientResponse> call = service.getUsers(params.key);
        call.enqueue(new Callback<ClientResponse>() {
            @Override public void onResponse(Call<ClientResponse> call, Response<ClientResponse> response) {
                ClientResponse apiResponse = response.body();
                if (apiResponse != null) {
                    List<Client> responseItems = apiResponse.getUsers();
                    callback.onResult(responseItems, params.key + 1);
                }
            }
            @Override public void onFailure(Call<ClientResponse> call, Throwable t) {
            }
        });
    }
}