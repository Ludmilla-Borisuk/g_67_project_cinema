package app.controller;

import app.domain.Genre;
import app.domain.Ticket;
import app.service.TicketService;

import java.util.List;

public class TicketController {

    private final TicketService service = TicketService.getInstance();

    public Ticket save(String title, String price, String genre) {
        double numericPrice = Double.parseDouble(price);
        Genre genre1 = Genre.valueOf(genre.toUpperCase());
        Ticket ticket = new Ticket(numericPrice, genre1, title);
        return service.save(ticket);
    }

    public List<Ticket> getAll() {
        return service.getALLActiveTickets();
    }

    public Ticket getById(String id) {
        long numericId = Long.parseLong(id);
        return service.getActiveTicketById(numericId);
    }

    public void update(String id, String newPrice) {
        long numericId = Long.parseLong(id);
        double numericNewPrice = Double.parseDouble(newPrice);
        service.update(numericId, numericNewPrice);
    }

    public void deleteById(String id) {
        long numericId = Long.parseLong(id);
        service.deleteById(numericId);
    }

    public void deleteByTitle(String title) {
        service.deleteByTitle(title);
    }

    public void restoreById(String id) {
        long numericId = Long.parseLong(id);
        service.restoreById(numericId);
    }

    public int getTicketsCount() {
        return service.getActiveTicketsCount();
    }

    public double getTicketTotalCost() {
        return service.getActiveTicketsTotalCost();
    }

    public double getTicketsAveragePrice() {
        return service.getActiveTicketsAveragePrice();
    }

    public List<Ticket> getAllActiveTicketsByGenres(String genre) {
        Genre genre1 = Genre.valueOf(genre.toUpperCase());
        return service.getActiveTicketsByGenre(genre1);

    }
}