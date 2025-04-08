# Find all users
execute as @a[scores={moretotems.totems_used=1..}] run tag @s add moretotems.user

# Run totem processors
execute as @a[tag=moretotems.user,scores={moretotems.totem_hand=1}] run function moretotems:processors/run
execute as @a[tag=moretotems.user,scores={moretotems.totem_hand=2}] run function moretotems:processors/run

# Cleanup
execute as @a[tag=moretotems.user] run scoreboard players reset @s moretotems.totems_used
execute as @a[tag=moretotems.user] run tag @s remove moretotems.user
