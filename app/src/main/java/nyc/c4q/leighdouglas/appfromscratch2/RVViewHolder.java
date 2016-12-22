package nyc.c4q.leighdouglas.appfromscratch2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


/**
 * Created by leighdouglas on 12/6/16.
 */

public class RVViewHolder extends RecyclerView.ViewHolder {

    String TAG = "TAG";
    View mView;
    private TextView id;
    private TextView excerpt;
    private TextView date;
    //private TextView content;
    private TextView title;

    public RVViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        id = (TextView) mView.findViewById(R.id.id);
        excerpt = (TextView) mView.findViewById(R.id.excerpt);
        date = (TextView) mView.findViewById(R.id.date);
        //content = (TextView) itemView.findViewById(R.id.content);
        title = (TextView) mView.findViewById(R.id.title);

    }

    public void bind(final Posts posts) {
        //Log.d(TAG, "this worked");
        id.setText(Integer.toString(posts.getId()));
        excerpt.setText(posts.getExcerpt());
        date.setText(posts.getDate());
        title.setText(posts.getTitle());
        //content.setText(posts.getContent());
        mView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mView.getContext(), ActivityTwo.class);
                intent.putExtra(Constants.EXTRA_TITLE, posts.getTitle());
                intent.putExtra(Constants.EXTRA_ID, Integer.toString(posts.getId()));
                intent.putExtra(Constants.EXTRA_DATE, posts.getDate());
                intent.putExtra(Constants.EXTRA_CONTENT, posts.getContent());
                view.getContext().startActivity(intent);
            }
        });
    }
}
