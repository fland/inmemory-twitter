# inmemory-twitter
In-memory twitter like web app

## Build-deploy instructions
Prerequisites: java8, maven3

build using mvn clean package

deploy using java -jar inmemory-twitter-1.0-SNAPSHOT.jar

## Usage/API
Uses in-memory DB => requires some demo data to be inserted after launch

### Adding post
curl -H "Content-Type: application/json" -X POST -d '{"user":"max","messageText":"Hello world!"}' http://localhost:8080/message

Returns added post. 'user' parameter is required, otherwise HTTP 500 returned

### Getting user posts
curl http://localhost:8080/message?user=max

Returns user posts, latest first. 'user' parameter is required, otherwise HTTP 400 returned

### Following user
curl -H "Content-Type: application/json" -X POST -d '{"user":"max","followedUser":"peter"}' http://localhost:8080/follower

Returns added followed user details. 'user' and 'followedUser' parameters are required and this pair should be unique,
otherwise HTTP 500 returned

### Getting followed users
curl http://localhost:8080/follower?user=max

Returns followed users list. 'user' parameter is required, otherwise HTTP 400 returned

### Getting timeline (followed users posts)
curl http://localhost:8080/timeline?user=max

Returns followed users posts, latest first. 'user' parameter is required, otherwise HTTP 400 returned
