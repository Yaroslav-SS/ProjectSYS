package db;

import entity.Discipline;
import entity.Mark;
import entity.Student;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBManager {
    public static List<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root19&password=root19011994");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students where status = '1'");

            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSurname(rs.getString("surname"));
                st.setName(rs.getString("name"));
                st.setGroup(rs.getString("groupe"));
                st.setDate(rs.getDate("data"));
                st.setStatus(1);
                students.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Term> getAllActiveTerms() {
        ArrayList<Term> terms = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from terms where status = '1'");

            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term_name"));
                term.setDuration(rs.getString("term_duration"));
                term.setStatus(1);
                terms.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    public static List<Mark> getMarksByStudentAndTerm(String idStudent, String idTerm) {
        ArrayList<Mark> marks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select m.id as id_mark, m.mark, d.id as id_disc, d.discipline from marks as m\n" +
                    "left join terms_disciplines as td on m.id_term_discipline = td.id\n" +
                    "left join disciplines as d on td.id_disciplines = d.id\n" +
                    "where m.id_student = '" + idStudent + "' and td.id_term = '" + idTerm + "' and d.status = '1'");

            while (rs.next()) {
                Mark mark = new Mark();
                mark.setId(rs.getInt("id_mark"));
                mark.setMark(rs.getInt("mark"));

                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id_disc"));
                discipline.setDiscipline(rs.getString("discipline"));

                mark.setDiscipline(discipline);
                marks.add(mark);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;
    }

    public static Student getStudentById(String id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students where id = '" + id + "'");

            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSurname(rs.getString("surname"));
                st.setName(rs.getString("name"));
                st.setGroup(rs.getString("groupe"));
                st.setDate(rs.getDate("data"));
                return st;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean canLogin(String login, String password, String role) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users where login = '" + login + "' and password = '" + password + "' and role = '" + role + "'");

            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createStudent(String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `students` (`surname`, `name`, `groupe`, `data`) VALUES ('" + surname + "', '" + name + "', '" + group + "', '" + date + "');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `students` SET `status` = '0' WHERE (`id` = '" + id + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<Discipline> getAllActiveDiscipline() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// подтягивает драйвер внутрь приложения для подсоединения
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024"); //объект соединения вызывает метод соединения.
            Statement stmt = conn.createStatement(); // Statement создание чистого листа/запроса в mysql ,где теперь у соединения вызываем метод "создай запрос" который пока пуст
            ResultSet rs = stmt.executeQuery("select * from disciplines where status = '1'");

            while (rs.next()) { // проход по каждой строке в базе
                Discipline dis = new Discipline();
                dis.setId(rs.getInt("id"));
                dis.setDiscipline(rs.getString("discipline"));
                dis.setStatus(1);
                disciplines.add(dis);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;

    }

    public static void createDiscipline(String discipline) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");

            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `disciplines` (`discipline`) VALUES ('" + discipline + "');"); //

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDiscipline(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");

            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `disciplines` SET `status` = '0' WHERE (`id` = '" + id + "');"); //

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAvgMark(String idStudent, String idSelectedTerm) {
        double result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(
                    "select round(avg(" +
                            "case " +
                            "when marks.mark = 1 then 1 " +
                            "when marks.mark = 2 then 2 " +
                            "when marks.mark = 3 then 3 " +
                            "when marks.mark = 4 then 4 " +
                            "when marks.mark = 5 then 5 " +
                            "else 0 " +
                            "end), 1) as avg_mark from marks " +
                            "join terms_disciplines on marks.id_term_discipline = terms_disciplines.id " +
                            "join terms on terms_disciplines.id_term = terms.id " +
                            "join disciplines on terms_disciplines.id_disciplines = disciplines.id " +
                            " where marks.id_student = '" + idStudent + "' and terms_disciplines.id_term = '" + idSelectedTerm + "'");
            while (rs.next()) {
                result = rs.getDouble("avg_mark");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String s = " балла.";
        if (result == (int) result) {
            if (result == 1) {
                return (int) result + " балл.";
            }
            if (result == 5) {
                return (int) result + " баллов.";
            } else {
                return (int) result + s;
            }
        } else {
            return result + s;
        }
    }

    public static void modifyStudent(String surname, String name, String group, String date, String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            stmt.execute(
            "UPDATE `students` SET `surname` = '" + surname + "',`name` = '" + name + "',  `groupe` = '" + group + "', `data` = '" + date + "' WHERE (`id` = '" + id + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Discipline> getAllActivDisciplinesByTerm(int idTerm){
        ArrayList<Discipline> allDisciplines = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM terms_disciplines " +
                    "left join disciplines ON terms_disciplines.id_disciplines = disciplines.id" +
                    " where terms_disciplines.id_term = '" + idTerm + "' and disciplines.status = '1'");
            while (rs.next()){
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id_disciplines"));
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setStatus(1);
                allDisciplines.add(discipline);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allDisciplines;
    }


    public static Term getTermById(String idTerm) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM terms where id = " + idTerm);

            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setDuration(rs.getString("term_duration"));
                term.setTerm(rs.getString("term_name"));
                term.setStatus(1);
                return term;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void modifyTerm(String id, String modifiedDuration, String[] modifiedDisciplinesId) {
        int duration1 = 0;
        try {
            duration1 = Integer.parseInt(modifiedDuration.trim());

        } catch (NumberFormatException e) {
            Pattern pattern = Pattern.compile("\\D");
            Matcher matcher = pattern.matcher(modifiedDuration);

            int i = 0;
            if (matcher.find()){
                i = matcher.start();
            }
            duration1 = Integer.parseInt(modifiedDuration.substring(0,i));
        }
        String wordWeek= null;
        String durationString = String.valueOf(duration1);
        if ((duration1-1)%10==0 && duration1!=11){
            wordWeek= " неделя";
        }else if ((durationString.substring(durationString.length()-1).equals("2") ||
                durationString.substring(durationString.length()-1).equals("3") ||
                durationString.substring(durationString.length()-1).equals("4"))&&
                duration1!=12 && duration1!=13 && duration1!=14){
            wordWeek=" недели";
        }else{
            wordWeek = " недель";
        }
        String durationResult = duration1+wordWeek;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM `terms_disciplines` WHERE (`id_term` = '" + id + "')");
            if (modifiedDisciplinesId != null) {
                for (String newDisciplineId : modifiedDisciplinesId) {
                 stmt.execute("INSERT INTO `terms_disciplines` (`id_term`, `id_disciplines`) VALUES ('" + id + "', '" + newDisciplineId + "')");
                }
            }

            stmt.execute("UPDATE `terms` SET `term_duration` = '" + durationResult + "' WHERE (`id` = '" + id + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTerm(String duration, String[] disciplines) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT id,  term_name FROM terms ORDER BY ID DESC limit 1");
            String currentTerm = null;
            int idTerm = 0;
            while (resultSet.next()){
                currentTerm = resultSet.getString("term_name");
                idTerm =resultSet.getInt("id");
            }
            int termNumber = 0;
            termNumber = Integer.parseInt(currentTerm.substring(8));
            String term  = "Семестр_"+(++termNumber);
            stmt.execute("INSERT INTO `terms` (`term_name`, `term_duration`) VALUES ('" + term + "','" + duration + "')");

            int newId = ++idTerm;
            for (String discipline:disciplines) {
                ResultSet resultSet1 = stmt.executeQuery("SELECT id FROM disciplines" +
                        " where discipline ='" + discipline + "'");
                int idDiscipline = 0;
                while (resultSet1.next()){
                    idDiscipline = resultSet1.getInt("id");
                }

                stmt.execute("INSERT INTO `terms_disciplines` (`id_term`, `id_disciplines`) VALUES ('" + newId + "','" + idDiscipline + "')");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteTerm(String idTermDelete) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `terms` SET `status` = '0' WHERE (`id` = '" + idTermDelete + "');");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getDisciplineName(String id) {
        String name = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select discipline from disciplines where id =" + id + "");

            while (rs.next()) {
                name = rs.getString("discipline");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }
    public static void modifyDiscipline(String id, String modifiedDiscipline){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_44?user=root&password={jhjibqujl2024");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `disciplines` SET `discipline` = '" + modifiedDiscipline + "' WHERE (`id` = '" + id + "')");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}



