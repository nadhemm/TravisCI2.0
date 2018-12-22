package tn.insat.client;

import org.hibernate.Session;
import tn.insat.domain.Employee;
import tn.insat.domain.Task;
import tn.insat.util.HibernateUtil;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AppTeching_3_Demo_with_SELECT_Mode_With_Batch_Size {

	public static void main(String[] args) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            System.out.println("\n Fetch mode set to SELECT WITH BATCH Size - PLEASE NOTICE THE SQL GENERATED !!");

            System.out.println("Chargement de tous les employés");
            // create Criteria
            CriteriaQuery<Employee> criteriaQuery = session.getCriteriaBuilder().createQuery(Employee.class);
            criteriaQuery.from(Employee.class);

            List<Employee> employees = session.createQuery(criteriaQuery).getResultList();
            System.out.println("Nombre d'employés : " + employees.size());
            for (Employee employee : employees) {
                System.out.println(String.format("Feching Tasks for the employee:  %s ", employee.getName()));
                List<Task> tasks = employee.getTasks();
                for (Task task : tasks) {
                    System.out.println(String.format("     > Task :  %s ", task.getDescription()));
                }
            }
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
