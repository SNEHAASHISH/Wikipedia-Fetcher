NETWORKING CONCEPTS

HTTP

Acronym for Hypertext Transfer Protocol (HTTP) which is a set or protocols that enables communications between client(request)
and servers(response).

- Majorly uses:-
        => GET request
            Used for requesting data from a specified resource
            - GET requests can be bookmarked
            - GET requests remain in the browser history
            - GET requests have length restrictions
            - GET requests are only used to request data (not modify)
            - GET requests should never be used when dealing with sensitive data
        => POST method
            Used to send data to a server to create/update a resource
            - POST requests do not remain in the browser history
            - POST requests cannot be bookmarked
            - POST requests have no restrictions on data length

JSON and GSON

JSON is a syntax for storing and exchanging data. It is used for communication in the network and involves specific rules. It
uses Key-Value pairs and arrays.

E.g.:- {"name":"Coder","age":17,"city":"Malappuram"}

GSON is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a
JSON string to an equivalent Java Objects.

    JSON library is used by adding dependencies using pom.xml

  - Object to JSON
    String json_name = new Gson().toJson(OBJECT);
  - JSON to Object
    Object object_name = new Gson().fromJson( json_name, Object.class );
