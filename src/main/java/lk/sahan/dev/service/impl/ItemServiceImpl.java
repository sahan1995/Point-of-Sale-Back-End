package lk.sahan.dev.service.impl;

import lk.sahan.dev.dto.ItemDTO;
import lk.sahan.dev.entity.Item;
import lk.sahan.dev.repository.ItemRepository;
import lk.sahan.dev.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemR;

    @Override
    public void saveItem(String ID, ItemDTO itemDTO) {

        if(!ID.equals(itemDTO.getCode())){
            throw new RuntimeException("ID not same");
        }
        Item item = new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand());
        itemR.save(item);
    }

    @Override
    public void updateIten(String ID, ItemDTO itemDTO) {
        if(!ID.equals(itemDTO.getCode())){
            throw new RuntimeException("ID not same");
        }
        Item item = new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand());
        itemR.save(item);
    }

    @Override
    public void deleteItem(String ID) {

        itemR.deleteById(ID);
    }

    @Override
    public ItemDTO findByID(String ID) {
        Optional<Item> itemO = itemR.findById(ID);
        if(itemO.isPresent()){
            Item item = itemO.get();
            return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(), item.getQtyOnHand());
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<ItemDTO> getAll() {

        List<Item> items = itemR.findAll();
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        items.forEach(i->{

            itemDTOS.add(new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        });
        return itemDTOS;
    }
}
