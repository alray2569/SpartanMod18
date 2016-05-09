@ECHO OFF
FOR %%X IN (diamond_helmet_f gold_helmet_f iron_helmet_f) DO (
FOR %%Y IN (0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15) DO (
ECHO {"parent": "builtin/generated","textures": {"layer0": "andrew_spartanmod:items/%%X%%Y"}, "display": {"thirdperson": { "rotation": [ -90, 0, 0 ], "translation": [ 0, 1, -3 ], "scale": [ 0.55, 0.55, 0.55 ]}, "firstperson": { "rotation": [ 0, -135, 25 ], "translation": [ 0, 4, 2 ], "scale": [ 1.7, 1.7, 1.7 ]}}} > %%X%%Y.json
)
)