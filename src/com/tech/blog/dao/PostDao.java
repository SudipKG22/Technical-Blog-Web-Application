package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;

public class PostDao {

	private Connection conn;

	// Constructor to initialize connection
	public PostDao(Connection conn) {
		this.conn = conn;
	}

	// Fetch all categories from the database
	public ArrayList<Category> getAllCategories() {
		ArrayList<Category> catList = new ArrayList<>();
		
		ResultSet rsCats = null;
        Statement stmt = null;

		try {
			String query = "select * from categories";
			stmt = conn.createStatement();
			rsCats = stmt.executeQuery(query);

			while (rsCats.next()) {
				int catId = rsCats.getInt("catid");
				String catName = rsCats.getString("catname");
				String catDesc = rsCats.getString("catdescription");

				Category cat = new Category(catId, catName, catDesc);
				catList.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close ResultSet and PreparedStatement
            try {
                if (rsCats != null) rsCats.close();
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}

		return catList;
	}

	// Insert a new post into the database
	public boolean addPost(Post newPost) {
		boolean isPostAdded = false;
		PreparedStatement pstmt = null;

		try {
			String query = "insert into posts (posttitle, postcontent, postcode, postimage, cat_id, puserid) "
					+ "values (?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, newPost.getPostTitle());
			pstmt.setString(2, newPost.getPostContent());
			pstmt.setString(3, newPost.getPostCode());
			pstmt.setString(4, newPost.getPostImage());
			pstmt.setInt(5, newPost.getCatgId());
			pstmt.setInt(6, newPost.getUserId());

			pstmt.executeUpdate();
			isPostAdded = true;

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

		return isPostAdded;
	}

	// Get all posts from the database
	public List<Post> getAllPosts() {
		List<Post> allPosts = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rsPosts = null;

		try {
			stmt = conn.createStatement();
			rsPosts = stmt.executeQuery("select * from posts order by postdate desc");

			while (rsPosts.next()) {
				int postId = rsPosts.getInt("postid");
				String postTitle = rsPosts.getString("posttitle");
				String postContent = rsPosts.getString("postcontent");
				String postCode = rsPosts.getString("postcode");
				String postImage = rsPosts.getString("postimage");
				Timestamp postDate = rsPosts.getTimestamp("postdate");
				int catId = rsPosts.getInt("cat_id");
				int userId = rsPosts.getInt("puserid");
				//System.out.println("--> " + postImage + " , " + postTitle);
				
				

				Post post = new Post(postId, postTitle, postContent, postCode, postImage, postDate, catId, userId);
				allPosts.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close ResultSet and PreparedStatement
            try {
                if (rsPosts != null) rsPosts.close();
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}

		return allPosts;
	}

	// Get posts by a specific category
	public List<Post> getPostsByCategory(int catId) {
		List<Post> posts = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rsPosts = null;

		try {
			String query = "select * from posts where cat_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, catId);  

			rsPosts = pstmt.executeQuery();

			while (rsPosts.next()) {
				int postId = rsPosts.getInt("postid");
				String postTitle = rsPosts.getString("posttitle");
				String postContent = rsPosts.getString("postcontent");
				String postCode = rsPosts.getString("postcode");
				String postImage = rsPosts.getString("postimage");
				Timestamp postDate = rsPosts.getTimestamp("postdate");
				int userId = rsPosts.getInt("puserid");

				Post post = new Post(postId, postTitle, postContent, postCode, postImage, postDate, catId, userId);
				posts.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close ResultSet and PreparedStatement
            try {
                if (rsPosts != null) rsPosts.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}

		return posts;
	}
	
	public Post getPostByPostId(int postid) {
		Post post = null;
		
		PreparedStatement pstmt = null;
		ResultSet rsPosts = null;
		
		try {
			String query = "select * from posts where postid = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postid);

			rsPosts = pstmt.executeQuery();

			while (rsPosts.next()) {
				int postId = rsPosts.getInt("postid");
				String postTitle = rsPosts.getString("posttitle");
				String postContent = rsPosts.getString("postcontent");
				String postCode = rsPosts.getString("postcode");
				String postImage = rsPosts.getString("postimage");
				Timestamp postDate = rsPosts.getTimestamp("postdate");
				int userId = rsPosts.getInt("puserid");
				int catId = rsPosts.getInt("cat_id");

				post = new Post(postId, postTitle, postContent, postCode, postImage, postDate, catId, userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close ResultSet and PreparedStatement
            try {
                if (rsPosts != null) rsPosts.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		
		return post;
	}
}
