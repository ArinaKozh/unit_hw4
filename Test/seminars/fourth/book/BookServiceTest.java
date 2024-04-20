package seminars.fourth.book;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

public class BookServiceTest {

    BookRepository mockBookRepo = mock(BookRepository.class);

    BookService bookService = new BookService(mockBookRepo);

    @Test
    void findByIdTimes(){
        bookService.findBookById("1");
        verify(mockBookRepo, times(1)).findById("1");
    }

    @Test
    void findById(){
        when(mockBookRepo.findById("1")).thenReturn(new Book("1", "Книга 1", "я"));
        assert mockBookRepo.findById("1").getTitle() == "Книга 1";
    }



}
