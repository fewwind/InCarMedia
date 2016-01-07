package com.example.fewwind.myfirst.serializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fewwind on 2015/11/3.
 */
public class Book implements Parcelable {

    private String bookName;
    private String author;
    private int publishTime;

    public Book(String bookName, String author, int publishTime) {
        this.bookName = bookName;
        this.author = author;
        this.publishTime = publishTime;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publishTime=" + publishTime +
                '}';
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {

            Book book = new Book();
            book.bookName = in.readString();
            book.author = in.readString();
            book.publishTime = in.readInt();

            return book;
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookName);
        dest.writeString(author);
        dest.writeInt(publishTime);
    }
}
