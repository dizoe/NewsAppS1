package com.example.android.newsapps1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class News_Adapter extends ArrayAdapter<News> {

    public News_Adapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.image);

        Picasso.get().load(currentNews.getImage()).into(imageView);

        TextView titleView = listItemView.findViewById(R.id.title);

        titleView.setText(currentNews.getTitle());

        TextView sectionNameView = listItemView.findViewById(R.id.section_name);

        sectionNameView.setText(currentNews.getSectionName());

        TextView authorNameView = listItemView.findViewById(R.id.author_name);

        if (currentNews.getAuthorName() != "") {
            authorNameView.setText(currentNews.getAuthorName());

            authorNameView.setVisibility(View.VISIBLE);
        } else {

            authorNameView.setVisibility(View.GONE);
        }

        TextView dateView = null;
        TextView timeView = null;
        if (currentNews.getPublicationDate() != null) {
            dateView = listItemView.findViewById(R.id.date);

            String formattedDate = formatDate(currentNews.getPublicationDate()).concat(",");

            dateView.setText(formattedDate);

            timeView = listItemView.findViewById(R.id.time);

            String formattedTime = formatTime(currentNews.getPublicationDate());

            timeView.setText(formattedTime);

            dateView.setVisibility(View.VISIBLE);
            timeView.setVisibility(View.VISIBLE);
        } else {

            dateView.setVisibility(View.GONE);
            timeView.setVisibility(View.GONE);
        }

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
