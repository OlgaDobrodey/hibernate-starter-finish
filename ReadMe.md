docker run --name some-postgres -e POSTGRES_PASSWORD=password -p 5433:5432 -d postgres

session.evict(user1) -  delete user  from cache
session.clear(); - delete all cache
session.close(); - delete all cache
session.flush() - get changing in DB
session.isDirty() - result true - if in DB was changes, if not - false
session.refresh(Object object) - (void) - get data from DB
session.merge(Object object) - put data to DB
session.persist == session.saveOrUpdate

https://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/PatternLayout.html
<param name="conversionPattern" value="[%d{HH:mm:ss,SSS}] %p [%c: %L] %m%n"/>

@Access(AccessType.FIELD) - annotation up Field
@Transient - hibernate will not save field in date base(not transient field)

@Temporal(TemporalType.TIMESTAMP)
private Date date;      ----------transfer Date in Timestamp DB before 8JAVA

