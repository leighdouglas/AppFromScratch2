package nyc.c4q.leighdouglas.appfromscratch2;

import java.util.List;

/**
 * Created by leighdouglas on 12/6/16.
 */

public class WPPojo {
    List<Posts> posts;


    public List<Posts> getPosts() {
        return posts;
    }

    public void setWpPostsArray(List<Posts> wpPosts) {
        this.posts = wpPosts;
    }
}
