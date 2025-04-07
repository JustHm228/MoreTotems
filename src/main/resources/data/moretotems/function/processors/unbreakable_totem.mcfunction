# Check if the holding totem is unbreakable
execute unless entity @s[tag=moretotems.user] if entity @s[tag=moretotems.totem_in_mainhand,nbt={SelectedItem:{tag:{"Unbreakable":1b}}}] run tag @s add moretotems.unbreakable_totem_in_mainhand
execute unless entity @s[tag=moretotems.user] if entity @s[tag=moretotems.totem_in_offhand,nbt={Inventory:[{Slot:-106b,tag:{"Unbreakable":1b}}]}] run tag @s add moretotems.unbreakable_totem_in_offhand

# Restore the totem if it was unbreakable
execute if entity @s[tag=moretotems.user,tag=moretotems.unbreakable_totem_in_mainhand,scores={moretotems.totem_hand=1,moretotems.totems_used=1..}] run item replace entity @s weapon.mainhand with minecraft:totem_of_undying{Unbreakable:1b} 1
execute if entity @s[tag=moretotems.user,tag=moretotems.unbreakable_totem_in_offhand,scores={moretotems.totem_hand=2,moretotems.totems_used=1..}] run item replace entity @s weapon.offhand with minecraft:totem_of_undying{Unbreakable:1b} 1

# Cleanup
execute if entity @s[tag=moretotems.unbreakable_totem_in_mainhand,scores={moretotems.totem_hand=2}] run tag @s remove moretotems.unbreakable_totem_in_mainhand
execute if entity @s[tag=moretotems.unbreakable_totem_in_mainhand,tag=moretotems.unbreakable_totem_in_offhand] unless entity @s[nbt={Inventory:[{Slot:-106b,id:"minecraft:totem_of_undying",tag:{Unbreakable:1b}}]}] run tag @s remove moretotems.unbreakable_totem_in_offhand

execute if entity @s[tag=moretotems.unbreakable_totem_in_mainhand,nbt={SelectedItem:{id:"minecraft:totem_of_undying"}}] unless entity @s[nbt={SelectedItem:{tag:{Unbreakable:1b}}}] run tag @s remove moretotems.unbreakable_totem_in_mainhand
execute if entity @s[tag=moretotems.unbreakable_totem_in_offhand,nbt={Inventory:[{Slot:-106b,id:"minecraft:totem_of_undying"}]}] unless entity @s[nbt={Inventory:[{Slot:-106b,tag:{Unbreakable:1b}}]}] run tag @s remove moretotems.unbreakable_totem_in_offhand
