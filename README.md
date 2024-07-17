# E-commerce Application

## Overview
This application provides several APIs for an eCommerce platform, implementing a wishlist feature and sales reporting functionalities.

## APIs

| Endpoint                                                | Method | Description                                     |
|-----------------------------------------------          |--------|-------------------------------------------------|
| `/api/v1/wish-lists/all?customerId={customerId}`                                | GET    | Returns the wishlist of a customer              |
| `/api/v1/total-sale`                                    | GET    | Returns total sale amount of the current day or any date range     |
| `/api/v1/max-sale-date?startDate={date}&endDate={date}` | GET    | Returns max sale day in a given range           |
| `/api/v1/top-selling-products?limit={limit}`                          | GET    | Returns top 5 selling items of all time          |
| `/api/v1/top-selling-products-time-range?startDate={date}&endDate={date}&limit={limit}`               | GET    | Returns top 5 selling items of the last month    |

## Running the application
This project can be run basically in two ways. One is using docker, other way is to run manually via Intellij Idea.

## Data Seeding
To generate dummy data, a sql script has been added.



