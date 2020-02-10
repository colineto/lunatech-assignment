# LunaTech Assignment - LunaFactory

## The project
This project is an API that enables querying products from an external API.  
It allows applying filters and specific queries on them.  

### External API used for that project
The external API is LunaFactory available at http://factory.lunatech.fr/  
Documentation : http://factory.lunatech.fr/docs/swagger-ui/index.html?url=/assets/swagger/swagger.json#/

## Launch the project
Move into Lunatech directory  
Then run `sbt run`

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
