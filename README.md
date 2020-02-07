# LunaTech Assignment

## website that get products from Luna Factory 

This website runs on localhost:9000

It handles two endpoints :
* */products* which is able to display all the products of luna factory
* */products/assembled* which is a specific page for newbies that only shows already assembled furniture

On each of those you can add some query parameters to filters the products
* *sort* [String] allows sorting by "name" or "price"
* *order* [String] specify the sorting by "asc" or "desc"
* *limit* [Int] filter the number of products 
 
For example to answer the two assignment questions :
1- The 15 most expensive products
    **localhost:9000/products?sort=price&order=desc&limit=15**
2- Alphabetically ordered already assembled furniture with no duplicates
    **localhost:9000/products/assembled?sort=name**

To run it : *sbt run*

