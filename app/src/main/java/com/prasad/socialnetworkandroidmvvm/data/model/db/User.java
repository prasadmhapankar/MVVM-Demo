package com.prasad.socialnetworkandroidmvvm.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created By Prasad on 2020-05-24.
 */


@Entity(tableName = "users")
public class User {

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @PrimaryKey
    public Long id;

    public String name;

    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}
