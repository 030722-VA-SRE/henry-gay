//package com.revature.services;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.revature.daos.BookDao;
//
///*-
// *  Unimplemented due to error java.lang.NullPointerException:
// *  Cannot invoke "com.revature.daos.BookDao.getAllBooks()" because "this.bDao" is null
//*/
//@ExtendWith(MockitoExtension.class)
//class BookServiceTest {
//
//	@Mock
//	private BookService underTest;
//	private BookDao mockDao;
//
//	@BeforeEach
//	void setUp() {
//		underTest = new BookService(mockDao);
//	}
//
//	@Test
//	@Disabled
//	void testBookService() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void canTestGetAllBooks() {
//		// when
//		when(underTest.getAllBooks());
//		// then
//		verify(mockDao).getAllBooks();
//	}
//
//	@Test
//	@Disabled
//	void testGetBooksByTitle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testGetBooksByAuthor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testGetBooksByTitleAndAuthor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testGetById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testAddBook() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testUpdateBook() {
//		fail("Not yet implemented");
//	}
//
//}
