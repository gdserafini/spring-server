package com.gdserafini.springServer.utils.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface HashableRepository<T> extends JpaRepository<T, UUID> {}
