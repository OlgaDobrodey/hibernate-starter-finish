docker run --name some-postgres -e POSTGRES_PASSWORD=password -p 5433:5432 -d postgres

session.evict(user1) -  delete user  from cache
session.clear(); - delete all cache
session.close(); - delete all cache
session.flush() - get changing in DB
session.isDirty() - result true - if in DB was changes, if not - false