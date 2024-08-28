public class DependencyInjection {

    // Repository Interface
    public interface CustomerRepository {
        String findCustomerById(int id);
    }

    // Concrete Repository Implementation
    public static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(int id) {
            // Simulating a customer lookup
            return "Customer with ID " + id;
        }
    }

    // Service Class
    public static class CustomerService {
        private CustomerRepository customerRepository;

        // Constructor Injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public String getCustomerDetails(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    // Main method to test Dependency Injection
    public static void main(String[] args) {
        // Create a CustomerRepository instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        
        // Inject CustomerRepository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use CustomerService to find a customer
        String customerDetails = customerService.getCustomerDetails(1);
        System.out.println(customerDetails); // Output: Customer with ID 1
    }
}
