package nyc.c4q.leighdouglas.appfromscratch2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WPService {
    String BASE_URL = "http://www.washingtonpost.com/";

    @GET("wp-srv/simulation/simulation_test.json")
    Call<WPPojo> getWPPosts();

}
