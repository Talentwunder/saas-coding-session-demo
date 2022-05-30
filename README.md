# Connection:
Defines a connection between nodes (simplified with a string e.g "a").
Connection consists "from" and "to".

# Task:
Defines a collection of connections.

### "apply" method:
Using "apply" method, you can create inter-connection between existing connections.
the connection between the same "from" and "to" should not be possible.
e.g: 
``` 
var task = new Task()
task.apply("1",Arrays.asList("1"))
```   
should not create any connections.
In other word `task.getConnections()` should be empty.

# Example

``` 
var task = new Task()
task.apply("1",Arrays.asList("2", "3"))
```  
would make the task has the following connections:

- connection between "1" and "2"
- connection between "1" and "3"
- connection between "2" and "1"
- connection between "2" and "3"
- connection between "3" and "1"
- connection between "3" and "2"

another call of apply method, e.g:
```
task.apply("4",Arrays.asList("1"))
```

would make the task having an updated connections:

- connection between "1" and "2"
- connection between "1" and "3"
- connection between "1" and "4"
- connection between "2" and "1"
- connection between "2" and "3"
- connection between "2" and "4"
- connection between "3" and "1"
- connection between "3" and "2"
- connection between "3" and "4"
- connection between "4" and "1"
- connection between "4" and "2"
- connection between "4" and "3"


#### be advised that calling `task.apply("1",Arrays.asList("4"))` and `task.apply("4",Arrays.asList("1"))` would result the same
#### You are allowed to create new classes, methods, enums or anything that would help you achieve your goal.
