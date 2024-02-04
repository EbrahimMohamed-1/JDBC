package Ibrahimweb.jdpc_course.deo;


import java.util.List;
public interface employeedeo {
    List<employee>findAll();
    employee findAllByID(int id);
    void save(employee e);
    void deleteByID(int id);

}
