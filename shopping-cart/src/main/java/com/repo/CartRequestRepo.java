package com.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.CartRequest;

@Repository
public interface CartRequestRepo extends CrudRepository<CartRequest, Long> 
{
	List<CartRequest> findByuserId(Long userId);
	List<CartRequest> deleteAllByuserId(Long userId);
}
