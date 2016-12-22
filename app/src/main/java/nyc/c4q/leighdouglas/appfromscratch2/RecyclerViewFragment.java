package nyc.c4q.leighdouglas.appfromscratch2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leighdouglas on 12/8/16.
 */

public class RecyclerViewFragment extends Fragment {
    private static final String TAG = "Retrofit";
    private Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_recyclerview_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);


        //never run retrofit call in an onCreateView. You have to make sure that the layout is set,
        // and if the call takes too long to come back, the app will crash

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        runRetrofitCall();
    }

    public void runRetrofitCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WPService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WPService service = retrofit.create(WPService.class);
        Call<WPPojo> call = service.getWPPosts();

        call.enqueue(new Callback<WPPojo>() {
            @Override
            public void onResponse(Call<WPPojo> call, Response<WPPojo> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "Success");
                        adapter.setWpDataList(response.body().getPosts());
                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<WPPojo> call, Throwable t) {
                // Something went completely wrong (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });

    }
}
