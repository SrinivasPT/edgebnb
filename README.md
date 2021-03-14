# Edge BnB - Microservices
## With Spring Cloud - JPA - Mapstruct - SQL Server 

### To have the CRUD working, ensure that
- Mapstruct has collection strategy - ADDER_PREFERRED
- While setting the collection, on the entity, use the addAll collection method to set the new list
- On the entity, have the OneToMany Cascade type as ALL
- All the entities have the version attribute
- Retrieve the record before updating the record
