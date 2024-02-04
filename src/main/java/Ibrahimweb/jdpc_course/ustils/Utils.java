package Ibrahimweb.jdpc_course.ustils;

public class Utils {
    public static java.sql.Date GetDate(java.util.Date utilDate){
        return new java.sql.Date(utilDate.getTime());
    }
}
