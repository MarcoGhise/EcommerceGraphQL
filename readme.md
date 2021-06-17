## GraphiQL

http://localhost:8080/graphiql

### Get Orders
Get all PENDING orders with the mostexpensive product

```query
{
  ordersByStatus(status:PENDING)
  {
    id
    mostexpensive(count:1)
    {
      productId
      price
    }
		products{
      productId
      price
    }
  }
}
```

### Insert Order
Insert an order with two products and get the amount

```Insert a new Order with two products
mutation
{
  createOrder(status:"PENDING", createdAt:"2021-06-17 13:20:00", productsId:["CLE-24N", "KUS-24C"])
  {
    id
    amount
    products
    {
      price
    }
  }
}
```

## Rest Api
Get all PENDING orders with the mostexpensive product

http://localhost:8080/orders?status=PENDING&count=1