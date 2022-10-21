package vn.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.book.model.Customer;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @Query(value = "update customer set address =:address, city =:city, customer_name =:customerName, " +
            " district =:district, note =:note, phone_number =:phoneNumber, images =:images, date_of_birth =:dateOfBirth where id =:id", nativeQuery = true)
    void editCustomer(@Param("address") String address, @Param("city") String city, @Param("customerName") String customerName
    , @Param("district") String district, @Param("note") String note, @Param("phoneNumber") String phoneNumber, @Param("images") String images, @Param("dateOfBirth") LocalDate dateOfBirth, @Param("id") int id);

    @Query(value = "select * from customer where user_id = :userId", nativeQuery = true)
    Customer findByUserId(@Param("userId") int userId);
}
