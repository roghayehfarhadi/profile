package com.raha.profile.user.repository;

import com.raha.profile.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserInformation> findByUserNameAndPassword(String userName, String password);
}
