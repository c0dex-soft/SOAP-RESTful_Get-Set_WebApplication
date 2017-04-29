# SOAP-RESTful Get-Set WebApplication
Small web application for getting customer details from MySQL database and create new / update existing customer

* Used tools and technologies: Eclipse, Maven, SpringMVC, Hibernate, SOAP/RESTful, JSP, CSS, MySQL

* Description of methods functionality:
  * GetCustomerDetails method:
    * The input to this method should be: CustomerID (Number – Mandatory)
    * This method sholud return the following details for the associated customer ID – if any field is null, it should still be returned but with the null value. Returned datas should be CustomerID (Number), FirstName (String), LastName (String), Email (String), PhoneNumber (String)
    * If this CustomerID doesn’t exist in the persistence storage, return the page with information saying customer not found
    * If mandatory fields aren’t passed in, return the page with information about an invalid input error
    * If any other issues occurs, return the generic error page
    
  * SetCustomerDetails method:
    * The input to this method should be: CustomerID (Number – Optional – if this is not passed int, a new customer record should be created – if it is passed in and matches an existing record, update it), FirstName (String – Mandatory), LastName (String – Optional), Email (String – Optional), PhoneNumber (String – Optional)
    * This method should return the following details for either the newly created or update customer record: CustomerID (Number), FirstName (String), LastName (String), Email (String), PhoneNumber (String)
    * If this CustomerID doesn’t exist in the persistence storage, return the page with information saying customer not found
    * If mandatory fields aren’t passed in, return the page with information about an invalid input error
    * If any other issues occurs, return the generic error page
