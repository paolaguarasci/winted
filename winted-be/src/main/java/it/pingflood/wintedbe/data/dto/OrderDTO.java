package it.pingflood.wintedbe.data.dto;

import it.pingflood.wintedbe.data.entity.Customer;

public record OrderDTO(java.util.UUID id, Customer customer,
                       it.pingflood.wintedbe.data.entity.Product product) {
}
