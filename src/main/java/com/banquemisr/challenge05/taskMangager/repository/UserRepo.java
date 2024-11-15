package com.banquemisr.challenge05.taskMangager.repository;

import com.banquemisr.challenge05.taskMangager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
