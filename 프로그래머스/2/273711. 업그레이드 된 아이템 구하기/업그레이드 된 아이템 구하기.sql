select i.item_id, i.item_name, i.rarity
from item_info i
join item_tree t on t.item_id = i.item_id
join item_info i2 on t.parent_item_id = i2.item_id
where i2.rarity = 'RARE'
order by i.item_id desc;