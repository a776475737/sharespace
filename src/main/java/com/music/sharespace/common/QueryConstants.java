package com.music.sharespace.common;

public abstract class QueryConstants {

    public static String createNewUser = "INSERT INTO users VALUES (?,?,?,?,?)";
    public static String createNewAuthority = "INSERT INTO authorities VALUES (?,?)";
    public static String fetchUserList = "SELECT username FROM users";

}
