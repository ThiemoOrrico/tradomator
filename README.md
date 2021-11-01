# tradomator

## Introduction

Cryptocurrency is a highly volatile market.
It serves potential participating in rapidly changing values up and down.
That represents , which is a high risk at the same time. 
Approach is to create a tool that monitors changes on the market and reacts automatically.



## Development

### Setup Development environment on Github.
#### 0.1 Github Repo with Maven workflow

- CI: continuous integration
  - maven build
  - 

- CD: continuous deployment:
- docker / mongoDB - mongo cloud / 
- heroku deployment
#### 0.2 Setup local environment on Intelij
- BACKEND:
- Spring Initalizr or create Module
- pom.xml dependencies
- Result: Spring Boot Application

- FRONTEND
- React: npx create-react-app name-of-project im Terminal 
- Create Frontend Folder 
- npm install npm start

### Sketch: [UI](./bitmaps/tradomatorScribble211025.pdf)

#### US-1: "User Story 1" - Create model DTO 
- 1.0 Explore [Binance Test REST API](https://binance-docs.github.io/apidocs/spot/en/#change-log) 
- 1.1 Endpoint to "get" overview last 24hrs: {{url}}/api/v3/ticker/24hr
````json

"symbol": "BNBBUSD",
        "priceChange": "0.00000000",
        "priceChangePercent": "0.000",
        "weightedAvgPrice": "389.52000000",
        "prevClosePrice": "389.52000000",
        "lastPrice": "389.52000000",
        "lastQty": "28.02000000",
        "bidPrice": "0.00000000",
        "bidQty": "0.00000000",
        "askPrice": "389.52000000",
        "askQty": "572.67000000",
        "openPrice": "389.52000000",
        "highPrice": "389.52000000",
        "lowPrice": "389.52000000",
        "volume": "28.02000000",
        "quoteVolume": "10914.35040000",
        "openTime": 1635002206362,
        "closeTime": 1635088606362,
        "firstId": 1287,
        "lastId": 1317,
        "count": 31
    },
````
