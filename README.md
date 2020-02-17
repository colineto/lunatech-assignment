# LunaTech Assignment - LunaFactory

## The project
This Scala PLay2 project is an API that enables querying products from an external API.  
It allows applying filters and specific queries on them.  

#### External API used for that project
The external API is LunaFactory available at http://factory.lunatech.fr/  
Documentation : http://factory.lunatech.fr/docs/swagger-ui/index.html?url=/assets/swagger/swagger.json#/  
To connect you'll need to add your header to the request. It corresponds to two environment variables :
* TOKEN_KEY
* TOKEN_VALUE

## Launch the project
Into Lunatech directory  
Run `sbt run`   
Don't forget to specify the header needed to connect with the environment variables TOKEN_KEY and TOKEN_VALUE

#### Launch tests 
Into Lunatech directory  
Run `sbt test`

## How to use it
This website runs on localhost:9000

It handles two endpoints :
* **/products** which is able to display all the products of luna factory
* **/products/assembled** which is a specific page that only shows already assembled furniture

On each of those you can add some query parameters to filters the products
* **sort** [String] allows sorting by "name" or "price"
* **order** [String] specify the sorting by "asc" or "desc"
* **limit** [Int] filter the number of products 

## Examples - Assignment
For example to answer the two assignment questions :

1- Get the 15 most expensive products  

    `localhost:9000/products?sort=price&order=desc&limit=15`  
    
2- Get Alphabetically ordered already assembled furniture with no duplicates  

    `localhost:9000/products/assembled?sort=name`  

## Evolutions
This is a **WIP** project  
Some TODO's in the code are not resolved yet  
Some errors handling and tests are still to be implemented  
Moreover a front app in react to interact with this API is under construction
