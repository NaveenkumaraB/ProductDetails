Pre-requisites:
1.	Install java-8.
2.	Install Node-js.
3.	Install vs code.
4.	Eclipse
5.	mysql
Creat maven project:
Step-1: Download the maven project from the spring website start.spring.io . Add web, 		Mysql and JPA Dependencies into that project. Then generate the project, after that 	import it into eclipse application.
Step-2: Update the maven project --Project_name->maven->Update project.
Step-3: Create new package on src/main/java and create controller class for this project, 	mention the following annotation  
@CrossOrigin and @RestController above the class name. 	
Step-4: Inside the class, declare ProductDao class and mention Autowired	 above that. 
For Postmapping specify endpoint inside the bracket of @Postmapping 	annotation.
	@PostMapping(value = "/save")
Create one method with Parameters using annotation @RequestBody and mention return type for this method as String. Ans pass product class as a parameter.
	public String save(@RequestBody Product product)
Call the save() method from Dao and pass an object parameter, save this into a 	variable that returns class type. Return the result.
Product result=productDao.save(product);
return result.getId().toString();
Step-5: For Getmapping specify endpoint, produces inside the bracket of 	@Getmapping 	annotation.
Call findAll() method from Dao, save it into a variable and mention return type. Then 	return that variable.
Iterable<Product> res=productDao.findAll();
return (List) res; 
Step-6: Create another package with new entity Class, put @Entity annotation above the class name. Declare one ID variable put @Id,@GeneratedValue annotation above that variable. To define a variable as a column use @Column annotation, and you can mention a name for that column inside brackets of @Column annotation. And variable names must be lower case.	
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@Column(name="Name")
private String name;
 Generate getters and setters methods--Source->generate Getters and Setters.
Step-6:  Create another package with Dao Interface and Extends CrudRepository interface and pass entity class and long as generic.
public interface ProductDao extends CrudRepository<Product, Long>{}
Step-7: Mention the following code into application.properties.
	Type your project name on below code instead of /Sample3.
server.servlet.context-path=/Sample3
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/test
spring.datasource.username = root
spring.datasource.password = Naveen
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
Step-8: Put @ComponentScan annotation with controller class package path. And put @EntityScan annotation with Entities class package. @EnableJapRepositories annotation with Dao class package. Put @SpringBootApplication annotation. These all annotation must be above the main class.
Step-9:  Now, Build the project=>Project_name->Run As ->3 Maven Build, it takes 	into Edit Configuration dialogue box on that type Clean Install at Goal.
	To Run Project=>Project_name->Run As ->Java Application.
