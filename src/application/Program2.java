package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== Test 1: Department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== Test 2: Department findAll ===");
		List<Department> deList = departmentDao.findAll();
		deList.forEach(System.out::println);
		
		System.out.println("\n=== Test 3: Department insert ===");
		Department newDepartment = new Department (null,"Games");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = "+newDepartment.getId());
		
		System.out.println("\n=== Test 4: Department update ===");
		department = departmentDao.findById(1);
		department.setName("Magazines");
		departmentDao.update(department);
		System.out.println("Update complete");
		
		System.out.println("\n=== Test 6: Department deleteById ===");
		System.out.println("Enter an id for the delete test.");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Department deleted");
		sc.close();

	}

}
