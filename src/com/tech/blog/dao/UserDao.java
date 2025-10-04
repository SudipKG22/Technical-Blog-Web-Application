package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tech.blog.entities.User;

public class UserDao {
	
	private Connection conn;

	public UserDao(Connection conn) {
		this.conn = conn;
	}
	
	// Method to insert user registration info to the database
	public boolean addUser(User user) {
		boolean userAdded = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// creating sql query to insert a user
			String query = "insert into users "
						 + "(username, email, password, gender, about) "
						 + "values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
		
			// Set parameter values
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getAbout());
			
			// Execute insert query
			pstmt.executeUpdate();
			userAdded = true;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while inserting user.");
		} finally {
			// close ResultSet and PreparedStatement
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		
		return userAdded;
	}
	
	// Method to get User by email and password [Login]
	public User getUserByEmailAndPassword(String inputEmail, String inputPassword) {
		User userDetails = null;
		
		PreparedStatement pstmt = null;
		ResultSet userRS = null;
		
		try {
			// creating sql query to get user details
			String query = "select * from users where email = ? and password = ?";
			
			pstmt = conn.prepareStatement(query);
			
			// Set parameter values
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, inputPassword);
			
			// Execute insert query
			userRS = pstmt.executeQuery();

			if(userRS.next()) {
				userDetails = new User();
				
				userDetails.setUserName(userRS.getString("username"));
				userDetails.setUserId(userRS.getInt("userid"));
				userDetails.setPassword(userRS.getString("password"));
				userDetails.setGender(userRS.getString("gender"));
				userDetails.setAbout(userRS.getString("about"));
				userDetails.setRegDate(userRS.getTimestamp("regdate"));
				userDetails.setProfile(userRS.getString("profile"));
				userDetails.setEmail(userRS.getString("email"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while getting user details.");
		} finally {
			// close ResultSet and PreparedStatement
            try {
                if (userRS != null) userRS.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		
		return userDetails;
	}
	
	// Method to update User details
	public boolean updateUser(User user) {
		PreparedStatement pstmt = null;
		
		boolean userUpdated = false;
		try {
			// creating sql query to update user details
			String query = "update users set username = ?, email = ?, password = ?, about = ?, profile = ? "
						 + "where userid = ?";
			pstmt = conn.prepareStatement(query);
			
			// Set parameter values
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getAbout());
			pstmt.setString(5, user.getProfile());
			pstmt.setInt(6, user.getUserId());
			System.out.println("pstmt : " + pstmt.toString());
			
			// Execute update query
			pstmt.executeUpdate();
			userUpdated = true;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error while updating user details.");
		} finally {
			// close ResultSet and PreparedStatement
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}
		
		return userUpdated;
	}
	
	// Method to get User by userid
	 public User getUserByUserId(int userId) {
	        User user = null;
	        
	        PreparedStatement pstmt = null;
			ResultSet rsUser = null;
			
	        try {
	            String query = "select * from users where userid = ?";
	            
	            pstmt = conn.prepareStatement(query);
	            pstmt.setInt(1, userId);
	            
	            rsUser = pstmt.executeQuery();
	            
	            if (rsUser.next()) {
	                user = new User();


	                user.setUserName(rsUser.getString("username"));
	                user.setUserId(rsUser.getInt("userid"));
	                user.setEmail(rsUser.getString("email"));
	                user.setPassword(rsUser.getString("password"));
	                user.setGender(rsUser.getString("gender"));
	                user.setAbout(rsUser.getString("about"));
	                user.setRegDate(rsUser.getTimestamp("regdate"));
	                user.setProfile(rsUser.getString("profile"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	// close ResultSet and PreparedStatement
	            try {
	                if (rsUser != null) rsUser.close();
	                if (pstmt != null) pstmt.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        return user;
	    }
}
