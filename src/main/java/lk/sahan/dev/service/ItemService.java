package lk.sahan.dev.service;

import lk.sahan.dev.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {

    void saveItem(String ID,ItemDTO itemDTO);
    void updateIten(String ID,ItemDTO itemDTO);
    void deleteItem(String ID);
    ItemDTO findByID(String ID);
    ArrayList<ItemDTO> getAll();

}
