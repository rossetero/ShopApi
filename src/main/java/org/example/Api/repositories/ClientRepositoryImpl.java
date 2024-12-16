package org.example.Api.repositories;

import org.example.Api.models.Address;
import org.example.Api.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    private final JdbcTemplate jdbcTemplate;
    private final AddressRepository addressRepository;
    private final RowMapper<Client> clientRowMapper = (rs, rowNum) ->
            new Client((UUID) rs.getObject("id"),
                    rs.getString("client_name"),
                    rs.getString("client_surname"),
                    rs.getDate("birthday").toLocalDate(),
                    rs.getString("gender"),
                    rs.getTimestamp("registration_date").toLocalDateTime(),
                    (UUID) rs.getObject("address_id"));

    @Autowired
    public ClientRepositoryImpl(DataSource dataSource, AddressRepository addressRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveClient(Client client) {
        String q = "INSERT INTO clients(id, client_name, client_surname, birthday, gender, registration_date, address_id) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(q, client.getId(), client.getClientName(),
                client.getClientSurname(),
                client.getBirthday(),
                client.getGender(),
                client.getRegistrationDate(),
                client.getAddressId());
    }

    @Override
    public void deleteClient(UUID id) {
        jdbcTemplate.update("DELETE FROM clients WHERE id=?;", id); //добавить удаление зависимого адреса
    }

    @Override
    public Optional<Client> findClientByNameSurname(String name, String surname) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "select * from clients where client_name=? and client_surname=?;",
                    clientRowMapper, name, surname));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Client> findAll(int offset, int limit) { //добавить вывод зависимого адреса
        return jdbcTemplate.query(
                "select * from clients limit ? offset ?;",
                clientRowMapper, limit, offset);
    }

    @Override
    public List<Client> findAll() {
        return jdbcTemplate.query(
                "select * from clients;",
                clientRowMapper);
    }

    @Override
    public void updateClientAddress(UUID clientId, Address address) {
        UUID addressId = jdbcTemplate.queryForObject("select address_id from clients where id=?", UUID.class, clientId);
        address.setId(addressId);
        addressRepository.updateAddress(address);
    }

    @Override
    public Optional<Client> findClientById(UUID clientId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "select * from clients where id=?;",
                    clientRowMapper, clientId));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
