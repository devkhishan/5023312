interface CustomerRepository
{
    void findCustomerById();
}

class CustomerRepositoryImpl implements CustomerRepository
{
    @Override
    public void findCustomerById()
    {
        System.out.println("Finding customer by ID...");
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public void findCustomer()
    {
        customerRepository.findCustomerById();
    }
}

public class DependencyInjectionExample
{
    public static void main(String[] args)
    {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        customerService.findCustomer();
    }
}
