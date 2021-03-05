package com.hostbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostbook.domain.Item;
import com.hostbook.domain.User;
import com.hostbook.dto.ItemDTO;
import com.hostbook.dto.UserDTO;
import com.hostbook.exception.DataNotFoundException;
import com.hostbook.exception.NotAuthorizedException;
import com.hostbook.repository.ItemRepository;
import com.hostbook.repository.RoleRepository;
import com.hostbook.repository.UserRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserRepository userRepository;

	public Item getItem(ItemDTO itemDTO) {

		User user = userRepository.findByRoleIgnoreCase("USER");
		if (user == null) {
			throw new NotAuthorizedException("You have not authority to add Items in Stock");
		}

		Item item = new Item();
		item.setItemName(itemDTO.getItemName());

		// item.setItemImage(uri);
		item.setItemCategory(itemDTO.getItemCategory());
		item.setItemUnit(itemDTO.getItemUnit());
		item.setItemStatus(true);
		item.setItemCategory(itemDTO.getItemUnitPrice());
		item.setItemQuantity(itemDTO.getItemQuantity());

		Item save = itemRepository.save(item);

		return save;
	}

	public boolean deletItem(Integer id) {

		User user = userRepository.findByRoleIgnoreCase("USER");
		if (user == null) {
			throw new NotAuthorizedException("You have not authority to delete Items in Stock");
		}

		Optional<Item> findById = itemRepository.findById(id);
		if (findById == null) {
			throw new DataNotFoundException("Invalid Item Id");
		}
		itemRepository.deleteById(id);
		return true;

	}

	public List<Item> getAllItem() {
		List<Item> findAll = itemRepository.findAll();

		if (findAll == null) {
			throw new DataNotFoundException("Invalid Item Id");
		}

		return findAll;
	}

	public void updateItem(Long id, ItemDTO itemDTO) {

		User user = userRepository.findByRoleIgnoreCase("USER");
		if (user == null) {
			throw new NotAuthorizedException("You have not authority to update Items in Stock");
		}

		Optional<Item> findById = itemRepository.findById(id);
		if (findById == null) {
			throw new DataNotFoundException("Invalid Item Id");
		}

		Item item = findById.get();

		item.setItemName(itemDTO.getItemName());

		item.setItemCategory(itemDTO.getItemCategory());
		item.setItemUnit(itemDTO.getItemUnit());
		item.setItemStatus(true);
		item.setItemCategory(itemDTO.getItemUnitPrice());
		item.setItemQuantity(itemDTO.getItemQuantity());

		itemRepository.save(item);

	}

}
