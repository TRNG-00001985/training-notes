**Scenario:**
You are developing a role-playing game inspired by the Lord of the Rings series. The game will feature a diverse range of playable characters, each with unique abilities, skills, and traits drawn from the rich lore of the Tolkien universe.

The game world encompasses various regions of Middle-earth, each inhabited by different races and creatures. Some of the races include:

1. **Humans:** The race of Men, including the noble Dúnedain and the kingdoms of Gondor and Rohan.
2. **Elves:** The immortal Elven kindreds, such as the Noldor, Sindar, and Silvan Elves.
3. **Dwarves:** The stout and hardy Dwarven clans, skilled in crafting and mining.
4. **Hobbits:** The diminutive and resilient Halflings of the Shire.

Additionally, the game should feature various mythical creatures and foes, such as Orcs, Trolls, Dragons, and even the corrupted Nazgûl.

**Task:**
Implement an object-oriented design in Java to represent the different races, classes, creatures, and their respective abilities in the Lord of the Rings universe. Your solution should include the following:

**Phase 1:**

1. An abstract base class called `Character` that defines the common attributes and methods shared by all characters, such as name, race, level, and health. Set the value of health to 100 when the character is initialized, and modify the health based on actions like attack (reduce health by 30) and drink potion (increase health by 50).
2. Derived classes for each race (`Human`, `Elf`, `Dwarf`, `Hobbit`) that inherit from the `Character` class and implement their unique racial traits and abilities (e.g., Elven immortality, Dwarven resilience, Hobbit stealth).
3. An interface called `CharacterClass` that defines the common attributes and methods shared by all classes.
4. Implementing classes for different character classes (`Ranger`, `Wizard`, `Warrior`, `Commoner`, etc.) that implement the `CharacterClass` interface and define their unique class abilities (e.g., Ranger tracking, Wizard spellcasting, Warrior combat prowess).
5. An abstract base class called `Creature` that defines the common attributes and methods shared by all mythical creatures and foes, such as creature type, attack power, and special abilities.
6. Derived classes for different mythical creatures and foes (`Orc`, `Troll`, `Dragon`, `Nazgul`, etc.) that inherit from the `Creature` class and implement their unique abilities and behaviors.

**Phase 2:**


7. A `Combat` system that allows characters to battle against mythical creatures and foes, taking into account their race, class, abilities, and the creature's strengths and weaknesses.