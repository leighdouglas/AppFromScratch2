package nyc.c4q.leighdouglas.appfromscratch2;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leighdouglas on 12/6/16.
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    List<Posts> wpDataList;
    static String TAG = "TAG";

    public Adapter() {
        wpDataList = new ArrayList<>();
    }

    public Adapter(List<Posts> wpDataList) {
        this.wpDataList = wpDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Posts post = wpDataList.get(position);
        //Log.d(TAG, "onBindViewholder was successful");
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return wpDataList.size();
    }

    public List<Posts> getWpDataList() {
        return wpDataList;
    }

    public void setWpDataList(List<Posts> mwpAdapterList) {
        wpDataList.clear();
        wpDataList.addAll(mwpAdapterList);
        notifyDataSetChanged();

    }


}
