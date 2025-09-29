package app.controller;

import app.domain.Customer;
import app.service.CustomerService;

import java.util.List;

public class CustomerController {

    private final CustomerService service = new CustomerService();

    public Customer save(String name) {
        Customer customer = new Customer(name);
        return service.save(customer);
    }

    public List<Customer> getAll() {
        return service.getAllActiveCustomers();
    }

    public Customer getById(String id) {
        long numericId = Long.parseLong(id);
        return service.getActiveCustomerById(numericId);
    }

    public void update(String id, String newName) {
        long numericId = Long.parseLong(id);
        service.update(numericId, newName);
    }

    public void deleteById(String id) {
        long numericId = Long.parseLong(id);
        service.deleteById(numericId);
    }

    public void deleteByName(String name) {
        service.deleteByName(name);
    }

    public void restoreById(String id) {
        long numericId = Long.parseLong(id);
        service.restoreById(numericId);
    }

    public int getCustomersNumber() {
        return service.getActiveCustomersNumber();
    }

    public double getCustomerCartTotalCost(String customerId) {
        long numericCustomerId = Long.parseLong(customerId);
        return service.getCustomerCartTotalCost(numericCustomerId);
    }

    public double getCustomerCartAveragePrice(String customerId) {
        long numericCustomerId = Long.parseLong(customerId);
        return service.getCustomerCartAveragePrice(numericCustomerId);
    }

    public void addTicketToCustomersCart(String customerId, String ticketId) {
        long numericCustomerId = Long.parseLong(customerId);
        long numericTicketId = Long.parseLong(ticketId);
        service.addTicketToCustomerCart(numericCustomerId, numericTicketId);
    }

    public void removeTicketFromCustomerCart(String customerId, String ticketId) {
        long numericCustomerId = Long.parseLong(customerId);
        long numericTicketId = Long.parseLong(ticketId);
        service.removeTicketFromCustomerCart(numericCustomerId, numericTicketId);
    }

    public void clearCustomersCart(String customerId) {
        long numericCustomerId = Long.parseLong(customerId);
        service.clearCustomerCart(numericCustomerId);
    }
}
