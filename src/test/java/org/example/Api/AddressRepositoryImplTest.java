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
        UUID testId = UUID.fromString("eed4929e-4a60-4138-b0c1-5eb0a216ef55"); // Замените на реальный ID, который вы хотите протестировать
        Optional<Address> address = addressRepository.findAddressById(testId);

        assertThat(address.get()).isNotNull();
        assertThat(address.get().getId()).isEqualTo(testId);
        System.out.println(address.get());
    }
}
