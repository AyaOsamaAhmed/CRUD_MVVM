package crud.aya.test.com.Paging;

import androidx.lifecycle.MutableLiveData;
/*
public class DataSource extends PageKeyedDataSource<Long, Article> {

        private static final String TAG = DataSource.class.getSimpleName();

        /*
         * Step 1: Initialize the restApiFactory.
         * The networkState and initialLoading variables
         * are for updating the UI when data is being fetched
         * by displaying a progress bar
         */
  /*
        private RestApi restApiFactory;

        private MutableLiveData networkState;
        private MutableLiveData initialLoading;

        public DataSource() {
            this.restApiFactory = RestApi.create();

            networkState = new MutableLiveData();
            initialLoading = new MutableLiveData();
        }


        public MutableLiveData getNetworkState() {
            return networkState;
        }

        public MutableLiveData getInitialLoading() {
            return initialLoading;
        }


        /*
         * Step 2: This method is responsible to load the data initially
         * when app screen is launched for the first time.
         * We are fetching the first page data from the api
         * and passing it via the callback method to the UI.
         */
  /*
        @Override
        public void loadInitial(@NonNull LoadInitialParams<Long> params,
                                @NonNull LoadInitialCallback<Long, Article> callback) {

            initialLoading.postValue(NetworkState.LOADING);
            networkState.postValue(NetworkState.LOADING);

            appController.getRestApi().fetchFeed(QUERY, API_KEY, 1, params.requestedLoadSize)
                    .enqueue(new Callback<Feed>() {
                        @Override
                        public void onResponse(Call<Feed> call, Response<Feed> response) {
                            if(response.isSuccessful()) {
                                callback.onResult(response.body().getArticles(), null, 2l);
                                initialLoading.postValue(NetworkState.LOADED);
                                networkState.postValue(NetworkState.LOADED);

                            } else {
                                initialLoading.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
                                networkState.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
                            }
                        }

                        @Override
                        public void onFailure(Call<Feed> call, Throwable t) {
                            String errorMessage = t == null ? "unknown error" : t.getMessage();
                            networkState.postValue(new NetworkState(NetworkState.Status.FAILED, errorMessage));
                        }
                    });
        }



        @Override
        public void loadBefore(@NonNull LoadParams<Long> params,
                               @NonNull LoadCallback<Long, Article> callback) {

        }


        /*
         * Step 3: This method it is responsible for the subsequent call to load the data page wise.
         * This method is executed in the background thread
         * We are fetching the next page data from the api
         * and passing it via the callback method to the UI.
         * The "params.key" variable will have the updated value.
         */
    /*
        @Override
        public void loadAfter(@NonNull LoadParams<Long> params,
                              @NonNull LoadCallback<Long, Article> callback) {

            Log.i(TAG, "Loading Rang " + params.key + " Count " + params.requestedLoadSize);

            networkState.postValue(NetworkState.LOADING);

            appController.getRestApi().fetchFeed(QUERY, API_KEY, params.key, params.requestedLoadSize).enqueue(new Callback<Feed>() {
                @Override
                public void onResponse(Call<Feed> call, Response<Feed> response) {
                    /*
                     * If the request is successful, then we will update the callback
                     * with the latest feed items and
                     * "params.key+1" -> set the next key for the next iteration.
                     */
    /*
                    if(response.isSuccessful()) {
                        long nextKey = (params.key == response.body().getTotalResults()) ? null : params.key+1;
                        callback.onResult(response.body().getArticles(), nextKey);
                        networkState.postValue(NetworkState.LOADED);

                    } else networkState.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
                }

                @Override
                public void onFailure(Call<Feed> call, Throwable t) {
                    String errorMessage = t == null ? "unknown error" : t.getMessage();
                    networkState.postValue(new NetworkState(NetworkState.Status.FAILED, errorMessage));
                }
            });
        }
*/

