package org.example.Api;

import org.example.Api.models.Address;
import org.example.Api.repositories.AddressRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Используйте реальную базу данных
public class AddressRepositoryImplTest {

    @Autowired
    private AddressRepositoryImpl addressRepository;



    @Test
    public void connectionTestFindAddressById() {
        assertThat(addressRepository).isNotNull();


    }
}
