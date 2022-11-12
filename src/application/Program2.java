package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: Department findById ===");

		Department dep = departmentDao.findById(1);

		System.out.println(dep);

		System.out.println("=== TEST 2: Department findAll ===");

		List<Department> list = departmentDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== TEST 3: Department Insert ===");

		Department newDep = new Department(null, "Baby Clothes");

		departmentDao.insert(newDep);

		System.out.println("Inserted! New id = " + newDep.getId());

		System.out.println("=== TEST 5: Department Update ===");

		dep = departmentDao.findById(1);
		dep.setName("Computers");
		departmentDao.update(dep);

		System.out.println("Update Completed!");

		System.out.println("=== TEST 5: seller sellerDelete ===");

		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);

		System.out.println("Delete completed!");

		sc.close();
	}

}
