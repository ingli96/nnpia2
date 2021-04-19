package com.example.ingli.dao;

import com.example.ingli.Controller.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
