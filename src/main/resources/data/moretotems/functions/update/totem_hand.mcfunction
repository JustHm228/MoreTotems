# Check for totem in mainhand
execute as @a[nbt={SelectedItem:{id:"minecraft:totem_of_undying"}}] run tag @s add moretotems.totem_in_mainhand
execute as @a[tag=moretotems.totem_in_mainhand] run scoreboard players set @s moretotems.totem_hand 1

# Check for totem in offhand
execute as @a[nbt={Inventory:[{Slot:-106b,id:"minecraft:totem_of_undying"}]}] run tag @s add moretotems.totem_in_offhand
execute as @a[tag=moretotems.totem_in_offhand,tag=!moretotems.totem_in_mainhand] run scoreboard players set @s moretotems.totem_hand 2

# Run totem processors
execute as @a[tag=moretotems.totem_in_mainhand] run function moretotems:processors/run
execute as @a[tag=moretotems.totem_in_offhand,tag=!moretotems.totem_in_mainhand] run function moretotems:processors/run

# Cleanup
execute as @a[tag=moretotems.totem_in_mainhand,nbt=!{SelectedItem:{id:"minecraft:totem_of_undying"}}] run tag @s remove moretotems.totem_in_mainhand
execute as @a[tag=moretotems.totem_in_offhand,nbt=!{Inventory:[{Slot:-106b,id:"minecraft:totem_of_undying"}]}] run tag @s remove moretotems.totem_in_offhand

# (Do not uncomment!)
#execute as @a[scores={moretotems.totem_hand=1},nbt=!{SelectedItem:{id:"minecraft:totem_of_undying"}}] run scoreboard players reset @s moretotems.totem_hand
#execute as @a[scores={moretotems.totem_hand=2},nbt=!{Inventory:[{Slot:-106b,id:"minecraft:totem_of_undying"}]}] run scoreboard players reset @s moretotems.totem_hand
