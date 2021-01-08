package jpabook.jpashop.service;


import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }
    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

    @Transactional //dirty checking 로 update 엔티티변경시 변경감지를 사용하
    public void updateItem(Long itemId,String name,int price,int stockQuantity){
        Item findItem= itemRepository.findOne(itemId);
        findItem.setPrice(price); //set으로 바꾸는 것보다 의미있는 메서드를 넣어서 해당 메서드에서 변경하도록 하는것이 좋다.
        findItem.setName(name);//set을 사용하는것은 지양해라.
        findItem.setStockQuantity(stockQuantity);





    }


}
