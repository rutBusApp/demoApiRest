package com.wall.app.rest.Repository;

import com.wall.app.rest.Model.Task;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task,Long> {
}
