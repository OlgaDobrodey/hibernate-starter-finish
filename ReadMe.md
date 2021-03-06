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

@ManyToOne(
optional = false - do inner join
optional = true - (default) do left join

fetch = FetchType.LAZY - default for collection
fetch = FetchType.EAGER - default for Object


company = session.getReference(CompanyOneToMany .class, 1); -getProxy

SORT
@org.hibernate.annotations.OrderBy(clause = "username DESC, lastname ASC")
@javax.persistence.OrderBy("username DESC, personalInfo.lastname ASC")
@SortNatural
@SortComparator
 
@MapKey(name = "username")
@SortNatural
private Map<String, User> users = new TreeMap<>();
 
@ElementCollection
@CollectionTable(name = "company_locale", joinColumns = @JoinColumn(name = "company_id"))
//    @AttributeOverride(name = "lang", column = @Column(name = "language"))
//    private List<LocaleInfo> locales = new ArrayList<>();
@MapKeyColumn(name = "lang")
@Column(name = "description")
private Map<String, String> locales = new HashMap<>();



