import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime createdAt = LocalDateTime.parse("2021-05-27T12:54:53.740", formatter);
		//LocalDateTime createdAt = LocalDateTime.parse("2021-05-27T19:52:53.007332", formatter);
		System.out.println(createdAt);

	}

}
