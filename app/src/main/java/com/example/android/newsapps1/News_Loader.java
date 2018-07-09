package com.example.android.newsapps1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class News_Loader extends AsyncTaskLoader<List<News>> {

    private final String queryUrl;

    public News_Loader(Context context, String url) {
        super(context);
        queryUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (queryUrl == null) {
            return null;
        }

        return QueryUtils.fetchNewsData(queryUrl);
    }
}