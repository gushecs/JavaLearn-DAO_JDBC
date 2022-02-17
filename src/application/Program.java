package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== Test 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: Seller findByDepartment ===");
		Department department = new Department(2,null);
		List<Seller> seList = sellerDao.findByDepartment(department);
		seList.forEach(System.out::println);
		
		System.out.println("\n=== Test 3: Seller findAll ===");
		seList = sellerDao.findAll();
		seList.forEach(System.out::println);
		
		System.out.println("\n=== Test 4: Seller insert ===");
		Seller newSeller = new Seller (null,"Greg","greg@gmail.com",new Date(),4000.00,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+newSeller.getId());
		
		System.out.println("\n=== Test 5: Seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update complete");
		
		System.out.println("\n=== Test 6: Seller deleteById ===");
		System.out.println("Enter an id for the delete test.");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Seller deleted");
		sc.close();

	}

}
