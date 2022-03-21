package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Book;
import com.revature.util.ConnectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookPostgres implements BookDao {
	
	private static Logger log = LogManager.getRootLogger();
	
	@Override
	public List<Book> getAllBooks() {
		String sql = "select * from books;";
		List<Book> books = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Book newBook = new Book();
				newBook.setId(rs.getInt("id"));
				newBook.setIsbn(rs.getString("isbn"));
				newBook.setTitle(rs.getString("title"));
				newBook.setAuthor(rs.getString("author"));
				newBook.setYearPublished(rs.getInt("year_published"));

				books.add(newBook);
			}
		} catch (SQLException e) {
			log.error(e.fillInStackTrace());
			e.printStackTrace();
		}
		return books;
	}

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
			log.error(e.fillInStackTrace());
			e.printStackTrace();
		}
		// if an item of that id is found, returns that item, otherwise returns null
		return book;
	}
	@Override
	public List<Book> getBooksByTitle(String title) {
		String sql = "select * from books where title = ?;";
		List<Book> books = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, title);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Book newBook = new Book();
				newBook.setId(rs.getInt("id"));
				newBook.setIsbn(rs.getString("isbn"));
				newBook.setTitle(rs.getString("title"));
				newBook.setAuthor(rs.getString("author"));
				newBook.setYearPublished(rs.getInt("year_published"));
				
				books.add(newBook);
			}
		} catch (SQLException e) {
			log.error(e.fillInStackTrace());
			e.printStackTrace();
		}
		return books;
	}
	
	@Override
	public List<Book> getBooksByAuthor(String author) {
		String sql = "select * from books where author = ?;";
		List<Book> books = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, author);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Book newBook = new Book();
				newBook.setId(rs.getInt("id"));
				newBook.setIsbn(rs.getString("isbn"));
				newBook.setTitle(rs.getString("title"));
				newBook.setAuthor(rs.getString("author"));
				newBook.setYearPublished(rs.getInt("year_published"));
				
				books.add(newBook);
			}
		} catch (SQLException e) {
			log.error(e.fillInStackTrace());
			e.printStackTrace();
		}
		return books;
	}
	
	@Override
	public List<Book> getBooksByTitleAndAuthor(String title, String author) {
		String sql = "select * from books where title = ? or author = ?;";
		List<Book> books = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1,title);
			ps.setString(2, author);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Book newBook = new Book();
				newBook.setId(rs.getInt("id"));
				newBook.setIsbn(rs.getString("isbn"));
				newBook.setTitle(rs.getString("title"));
				newBook.setAuthor(rs.getString("author"));
				newBook.setYearPublished(rs.getInt("year_published"));
				
				books.add(newBook);
			}
		} catch (SQLException e) {
			log.error(e.fillInStackTrace());
			e.printStackTrace();
		}
		return books;
	}
	
	@Override
	public int addBook(Book book) {
		String sql = "insert into books(isbn, title, author, year_published) values (?,?,?,?)returning id;";
		int generatedId = -1;

		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);

//			ps.setInt(1, book.getId());
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setInt(4, book.getYearPublished());
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				generatedId = rs.getInt("id");
			}
		} catch (SQLException e) {
			log.error(e.fillInStackTrace());
			e.printStackTrace();
		}
		return generatedId;
	}

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
}