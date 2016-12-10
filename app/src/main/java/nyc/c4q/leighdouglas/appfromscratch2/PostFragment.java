package nyc.c4q.leighdouglas.appfromscratch2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by leighdouglas on 12/8/16.
 */

public class PostFragment extends Fragment{
    static String TAG2 = "tag";
    TextView titleView;
    TextView dateView;
    TextView contentView;
    TextView idView;
    private String title;
    private String id;
    private String content;
    private String date;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_fragment, container, false);

        titleView = (TextView) view.findViewById(R.id.titleView);
        dateView = (TextView) view.findViewById(R.id.dateView);
        contentView = (TextView) view.findViewById(R.id.contentView);
        idView = (TextView) view.findViewById(R.id.idView);

        ActivityTwo activityTwo = (ActivityTwo) getActivity();

        title = activityTwo.getPostTitle();
        id = activityTwo.getPostId();
        content = activityTwo.getPostContent();
        date = activityTwo.getPostDate();

        titleView.setText(title);
        dateView.setText(date);
        contentView.setText(content);
        idView.setText(id);

        return view;

    }
}
