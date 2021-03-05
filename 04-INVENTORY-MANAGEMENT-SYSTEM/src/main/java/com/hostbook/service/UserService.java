package com.hostbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostbook.domain.User;
import com.hostbook.dto.UserDTO;
import com.hostbook.exception.DataAlreadyExistException;
import com.hostbook.exception.DataNotFoundException;
import com.hostbook.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUserAccount(UserDTO userDTO) {
		User findByEmail = userRepository.findByEmail(userDTO.getEmail());
		User findByMobile = userRepository.findByMobile(userDTO.getMobile());

		if (findByEmail != null) {
			throw new DataAlreadyExistException("Data already exist with given Email ID");

		}

		if (findByMobile != null) {
			throw new DataAlreadyExistException("Data already exist with given Mobile number");
		}

		return saveUser(userDTO);

	}

	User saveUser(UserDTO userDTO) {

		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setGender(userDTO.getGender());
		user.setMobile(userDTO.getMobile());
		user.setRole(userDTO.getRole());
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setStatus(true);
		userRepository.save(user);

		return user;
	}

	public boolean updateUserAccount(Long id, UserDTO userDTO) {

		Optional<User> findById = userRepository.findById(id);
		if (!findById.isPresent()) {
			throw new DataNotFoundException("Invalid Id");
		}

		User user = findById.get();

		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setGender(userDTO.getGender());
		user.setMobile(userDTO.getMobile());
		user.setRole(userDTO.getRole());
        
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setStatus(true);

		userRepository.save(user);

		return true;
	}

}
