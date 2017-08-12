package ua.rafael.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import ua.rafael.dao.PogressSession;
import ua.rafael.model.Progress;
import ua.rafael.model.Subject;

public class MyBatisTrying {

//	@Test
//	public final void tryBayis() throws IOException {
//		AcademPerfomanceSession subjectDao = new AcademPerfomanceSession(
//				MyBatisConnectionFactory.getSqlSessionFactory());
//		System.out.println(subjectDao.selectAll());
//	}

	//
	// @Test
	// public final void testDropTable() {
	// SubjectDao subjectDao = new
	// SubjectDao(MyBatisConnectionFactory.getSqlSessionFactory());
	// subjectDao.dropTable();
	// }

	// @Test
	// public final void testCreateTable() {
	// SubjectSession subjectDao = new
	// SubjectSession(MyBatisConnectionFactory.getSqlSessionFactory());
	// System.out.println(subjectDao.createTable());
	// }
	//
	// @Test
	// public final void testInsert() {
	// SubjectSession subjectDao = new
	// SubjectSession(MyBatisConnectionFactory.getSqlSessionFactory());
	// subjectDao.insert(new Subject(1, "Mathematics"));
	// }

	// @Test
	// public final void testFindFile() {
	// String resource = "src\\main\\java\\ua\\rafael\\data\\Subject.xml";
	// System.out.println(FileUtil.readAllFromFile(resource));
	// }

	// @Test
	// public final void testDriverRegistration() throws ClassNotFoundException {
	// Class.forName("org.postgresql.Driver");
	// }
	//
	// @Test
	// public final void testConnectToDatabase() throws SQLException {
	// String url =
	// "jdbc:postgresql://localhost/university?user=postgres&password=postgres&ssl=false";
	// DriverManager.getConnection(url);
	// }
	//
	// @Test
	// public final void testSelectData() throws SQLException {
	// final String url
	// =
	// "jdbc:postgresql://localhost/university?user=postgres&password=admin&ssl=false";
	// Connection conn = DriverManager.getConnection(url);
	// Statement st = conn.createStatement();
	// ResultSet rs = st.executeQuery("SELECT name FROM public.subjects");
	// while (rs.next()) {
	// System.out.print("Column name returned ");
	// System.out.println(rs.getString(1));
	// }
	// rs.close();
	// st.close();
	// }
}
