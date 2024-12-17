package org.example.Api.repositories;

import org.example.Api.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AddressRepositoryImpl implements AddressRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Address> addressRowMapper = (rs, rowNum) ->
            new Address((UUID) rs.getObject("id"),
                    rs.getString("country"),
                    rs.getString("city"),
                    rs.getString("street"));

    @Autowired
    public AddressRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Address> findAddressById(UUID id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from addresses where id=?;", addressRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void saveAddress(Address address) {
        jdbcTemplate.update("INSERT INTO addresses (id, country, city, street) VALUES (?, ?, ?, ?);",
                address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getStreet());
    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update("UPDATE addresses SET country=?, city=?, street=? WHERE id=?;",
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getId());
    }

    @Override
    public void deleteAddress(UUID id) {
        jdbcTemplate.update("DELETE FROM addresses WHERE id=?;", id);
    }


}
