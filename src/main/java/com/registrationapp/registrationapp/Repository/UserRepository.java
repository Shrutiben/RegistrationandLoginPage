package com.registrationapp.registrationapp.Repository;

import com.registrationapp.registrationapp.Model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
//    @Override
//    <S extends UserDetails> S save(S entity);
//    Optional<UserDetails> findById(Integer id);


    boolean existsByEmail(String email);

    UserDtls findByEmail(String email);
}
