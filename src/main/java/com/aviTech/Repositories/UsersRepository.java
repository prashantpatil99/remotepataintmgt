package com.aviTech.Repositories;

import com.aviTech.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
