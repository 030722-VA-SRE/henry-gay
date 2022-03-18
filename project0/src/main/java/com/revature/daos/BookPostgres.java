package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.models.Book;
import com.revature.util.ConnectionUtil;

public class BookPostgres implements BookDao {

	@Override
	public Book getBookById(int id) {
		String sql = "select * from books where id = ?;";
		Book book = null;

		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setYearPublished(rs.getInt("year_published"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if an item of that id is found, returns that item, otherwise returns null
		return book;
	}
//	
//	@Override
//	public int createBook(Book book) {
//		String sql = "insert into books(id,isbn, title, author, year_published) values (?,?,?,?,?)returning id;";
//		int generatedId = -1;
//
//		try (Connection c = ConnectionUtil.getConnection()) {
//			PreparedStatement ps = c.prepareStatement(sql);
//
//			ps.setInt(1, book.getId());
//			ps.setString(2, book.getIsbn());
//			ps.setString(3, book.getTitle());
//			ps.setString(4, book.getAuthor());
//			ps.setInt(5, book.getYearPublished());
//			
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) {
//				generatedId = rs.getInt("id");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return generatedId;
//	}
//
//	@Override
//	public boolean updateBook(Book book) {
//		String sql = "update books set id = ?, isbn = ?, title = ?, author = ?, year_published = ?, where id = ?;";
//		int rowsChanged = -1;
//
//		try (Connection c = ConnectionUtil.getConnection()) {
//			PreparedStatement ps = c.prepareStatement(sql);
//
//			ps.setInt(1, book.getId());
//			ps.setString(2, book.getIsbn());
//			ps.setString(3, book.getTitle());
//			ps.setString(4, book.getAuthor());
//			ps.setInt(5, book.getYearPublished());
//
//			rowsChanged = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (rowsChanged < 1) {
//			return false;
//		}
//
//		return true;
//	}
//
//	@Override
//	public boolean deleteBookById(int id) {
//		String sql = "delete from books where id = ?;";
//		int rowsChanged = -1;
//
//		try (Connection c = ConnectionUtil.getConnection()) {
//			PreparedStatement ps = c.prepareStatement(sql);
//
//			ps.setInt(1, id);
//
//			rowsChanged = ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (rowsChanged < 1) {
//			return false;
//		}
//
//		return true;
//	}

}
