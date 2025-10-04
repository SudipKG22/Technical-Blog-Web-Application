package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao {

    Connection conn;

    public LikeDao(Connection conn) {
        this.conn = conn;
    }

    // insert a like for the given post and user
    public boolean insertLike(int postId, int userId) {
        boolean isInsertedSuccessfully = false;
        PreparedStatement pstmt = null;

        try {
            String query = "insert into likes(idpost, iduser) values(?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, postId);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
            isInsertedSuccessfully = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close PreparedStatement
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isInsertedSuccessfully;
    }

    // count number of likes on a given post
    public int countLikeOnPost(int postId) {
        int likeCount = 0;
        ResultSet rsCount = null;
        PreparedStatement pstmt = null;

        String query = "select count(*) as likecount from likes where idpost = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, postId);
            rsCount = pstmt.executeQuery();
            if (rsCount.next()) {
                likeCount = rsCount.getInt("likecount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close ResultSet and PreparedStatement
            try {
                if (rsCount != null) rsCount.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return likeCount;
    }

    // check if a specific user has liked a specific post
    public boolean isPostLikedByUser(int postId, int userId) {
        boolean isLikedByUser = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String query = "select * from likes where idpost = ? and iduser = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, postId);
            pstmt.setInt(2, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                isLikedByUser = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close ResultSet and PreparedStatement
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isLikedByUser;
    }

    // delete a like for the given post and user
    public boolean deleteLike(int postId, int userId) {
        boolean isDeleted = false;
        PreparedStatement pstmt = null;

        try {
            String query = "delete from likes where idpost = ? and iduser = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, postId);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
            isDeleted = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close PreparedStatement
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isDeleted;
    }
}
