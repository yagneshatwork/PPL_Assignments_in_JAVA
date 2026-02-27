import java.util.Scanner;

class Assignment4 {
	public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	vehicle v = null;

    	System.out.println("--- Vehicle Rental Shop ---");
    	System.out.println("1. Bike");
    	System.out.println("2. Car");
    	System.out.println("3. Truck");
    	System.out.print("Your chosen option: ");
    	int choice = sc.nextInt();
    	sc.nextLine(); // clear buffer

    	System.out.print("Enter vehicle model: ");
    	String model = sc.nextLine();

    	System.out.print("Enter number of rental days: ");
    	int days = sc.nextInt();

    	switch (choice) {
        	case 1:
            	v = new bike("Bike", model, days);
            	break;

        	case 2:
            	v = new car("Car", model, days);
            	break;

        	case 3:
            	v = new truck("Truck", model, days);
            	break;

        	default:
            	System.out.println("Invalid choice");
            	sc.close();
            	return;
    	}

    	System.out.println();
    	v.display();
    	System.out.println("Total Rental Fee: " + v.calculateRentalFee(days));

    	sc.close();
	}
}

class vehicle {
	String name;
	String model;
	double ratePerDay;
	int days;

	vehicle(String name, String model, double ratePerDay, int days) {
    	this.name = name;
    	this.model = model;
    	this.ratePerDay = ratePerDay;
    	this.days = days;
	}

	double calculateRentalFee(int days) {
    	return ratePerDay * days;
	}

	void display() {
    	System.out.println("Vehicle Type: " + name);
    	System.out.println("Model: " + model);
    	System.out.println("Rate per day: " + ratePerDay);
	}
}

class bike extends vehicle {
	bike(String name, String model, int days) {
    	super(name, model, 500, days);   
	}
}

class car extends vehicle {
	car(String name, String model, int days) {
    	super(name, model, 1000, days);  
	}
}

class truck extends vehicle {
	truck(String name, String model, int days) {
    	super(name, model, 2500, days);  
	}
}
