package _3_composicao._2_exercicio.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import _3_composicao._2_exercicio.entities.Client;
import _3_composicao._2_exercicio.entities.Order;
import _3_composicao._2_exercicio.entities.OrderItem;
import _3_composicao._2_exercicio.entities.Product;
import _3_composicao._2_exercicio.entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		
		System.out.print("Name: ");
		String clientName = scanner.nextLine();
		
		System.out.print("Email: ");
		String clientEmail = scanner.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirthDate = simpleDateFormat.parse(scanner.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(scanner.next());
		
		Order order = new Order(new Date(), orderStatus, client);
		
		System.out.print("How many items to this order? ");
		int n = scanner.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			
			System.out.print("Product name: ");
			scanner.nextLine();
			String productName = scanner.nextLine();
			
			System.out.print("Product price: ");
			Double productPrice = scanner.nextDouble();
			
			System.out.print("Quantity: ");
			Integer productQuantity = scanner.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		
		System.out.println(order);
		
		scanner.close();
	}
	
}
