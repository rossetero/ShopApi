package org.example.Api.repositories;

import org.example.Api.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AddressRepositoryImpl implements AddressRepository{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public AddressRepositoryImpl(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Address> getAddressById(UUID id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from addresses where id=?;",new AddressRowMapper(),id));
    }

    @Override
    public void saveAddress(Address address) {

    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update("UPDATE addresses SET country=?, city=?, street=? WHERE id=?",address.getCountry(),address.getCity(),address.getStreet(),address.getId());
    }

    @Override
    public void deleteAddress(UUID id) {
        jdbcTemplate.update("DELETE FROM addresses WHERE id=?",id);
    }

    private static class AddressRowMapper implements RowMapper<Address> {
        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Address((UUID) rs.getObject("id"),
                    rs.getString("country"),
                    rs.getString("city"),
                    rs.getString("street"));
        }
    }
}
