1) Each string means new carriage
2) Train should start with the creation of the locomative
3) Each type of carriages have their own id's that should be in the beggining of the string

Id accordint to carriage type:
- locomative
    00
- baggage carriages
    010 - simple baggage carriage
    011 - baggage carriage with cells
- cargo carriers
    020 - simple cargo carriers
    021 - liquid carriers
- extra carriages
    030 - restaurant carriage
- passanger carriages
    040 - simple passanger carriage
    041 - passanger carriage with rooms

    -- is used for ignored lines

Types of hook can be:
    A
    B
    C
    D
    I - special type used for unidentified types (don't use it)

List of required parametrs:
    * use space to separate parametres
    * if you want to use space in string parametr use underscore
    * parameters with ? in the end have only 2 options: ( + ) if true, ( - ) if false

    for all: Year of construction | expences per km | weight without cargo (cg) | model(string) | Type of hook

    00  - model(string) | power (horse powers)

    010 - for all + space for baggage(cubic metres) | maxLoadout(kg)
    011 - for all + number of cells | space per cell | max loadout per cell

    020 - for all + product name(string) | max loadout | is covered ? | has walls ?
    021 - for all + product name(string) | max loadout | is explosive ? | is refrigerated ?

    030 - for all + number of seats | has bar ?

    040 - for all + total number of places | price per place
    041 - for all + price per place | number of rooms | places per room


