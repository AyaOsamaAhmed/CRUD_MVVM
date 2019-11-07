package crud.aya.test.com.Paging;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
        @GET("users")
        Call<ClientResponse> getUsers(@Query("page") long page);
}
