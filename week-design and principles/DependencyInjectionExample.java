// DependencyInjectionExample.java

// Step 2: Define Repository Interface
interface CustomerRepository {
    String findCustomerById(String id);
}

// Step 3: Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        // Simulated database lookup
        return "Customer ID: " + id + ", Name: Pushpa, Location: Chennai";
    }
}

// Step 4: Service Class
class CustomerService {
    private CustomerRepository repository;

    // Step 5: Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomer(String id) {
        String customer = repository.findCustomerById(id);
        System.out.println(customer);
    }
}

// Step 6: Test Dependency Injection
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create Repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject into Service using constructor
        CustomerService service = new CustomerService(repository);

        // Use service to find and display customer
        service.displayCustomer("C102");
    }
}
