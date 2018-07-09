package com.example.android.newsapps1;

import java.util.Date;

/**
 * An {@link News} object contains information related to a single news.
 */
public class News {

    private final String newsTitle;

    private final String newsSectionName;

    private final String newsAuthorName;

    private final Date newsPublicationDate;

    private final String newsUrl;

    private final String newsImage;

    public News(String title, String section, String authorFullName, Date publicationDate, String url, String image) {
        newsTitle = title;
        newsSectionName = section;
        newsAuthorName = authorFullName;
        newsPublicationDate = publicationDate;
        newsUrl = url;
        newsImage = image;
    }

    public String getTitle() {
        return newsTitle;
    }

    public String getSectionName() {
        return newsSectionName;
    }

    public String getAuthorName() {
        return newsAuthorName;
    }

    public Date getPublicationDate() {
        return newsPublicationDate;
    }

    public String getUrl() {
        return newsUrl;
    }

    public String getImage() {
        return newsImage;
    }
}