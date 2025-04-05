# Remove scoreboards
scoreboard objectives remove moretotems.totems_used
scoreboard objectives remove moretotems.totem_hand

# Remove tags
execute as @e[tag=moretotems.totem_in_mainhand] run tag @s remove moretotems.totem_in_mainhand
execute as @e[tag=moretotems.totem_in_offhand] run tag @s remove moretotems.totem_in_offhand
execute as @e[tag=moretotems.user] run tag @s remove moretotems.user
execute as @e[tag=moretotems.unbreakable_totem_in_mainhand] run tag @s remove moretotems.unbreakable_totem_in_mainhand
execute as @e[tag=moretotems.unbreakable_totem_in_offhand] run tag @s remove moretotems.unbreakable_totem_in_offhand
