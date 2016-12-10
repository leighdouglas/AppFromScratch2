package nyc.c4q.leighdouglas.appfromscratch2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by leighdouglas on 12/7/16.
 */

public class ActivityTwo extends AppCompatActivity {
    private static final String TAG = "Title";
    private String content;
    private String title;
    private String date;
    private String id;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent = getIntent();

        title = intent.getStringExtra(Constants.EXTRA_TITLE);
        id = intent.getStringExtra(Constants.EXTRA_ID);
        date = intent.getStringExtra(Constants.EXTRA_DATE);
        content = intent.getStringExtra(Constants.EXTRA_CONTENT);

        Log.d(TAG, date);

        showPost();

    }

    private void showPost(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.post_fragment_container, new PostFragment());
        fragmentTransaction.commit();
    }

    public String getPostTitle(){
        return title;
    }

    public String getPostContent() {
        return content;
    }


    public String getPostDate() {
        return date;
    }

    public String getPostId() {
        return id;
    }

}

