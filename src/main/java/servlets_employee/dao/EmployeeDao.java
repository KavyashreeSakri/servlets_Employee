package servlets_employee.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlets_employee.dto.Employee;



public class EmployeeDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();

	}

	public void saveEmployee(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(employee);
		entityTransaction.commit();
	}

	public void updateEmployee(int emp_id, Employee employee ) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee newEmployee = entityManager.find(Employee.class, emp_id);
		if (newEmployee != null) {

			employee.setEmp_id(emp_id);;
			entityTransaction.begin();

			entityManager.merge(employee);

			entityTransaction.commit();
		} else {
			System.out.println("Employee not found");
		}
	}
	public Employee LoginEmployee(int emp_id)
	{
		EntityManager entityManager=getEntityManager();
		String jpql="SELECT e FROM Employee e where e.emp_id=?1";
		
		Query query= entityManager.createQuery(jpql);
		
		query.setParameter(1, emp_id);
		Employee employee=(Employee)query.getSingleResult();
		
//		Employee employee=entityManager.find(Employee.class, emp_id);
		
		return employee;
		
		
	}
}
