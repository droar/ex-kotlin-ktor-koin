# Example using Kotlin Ktor and Koin for dependency injection.
Small example for research purposes on Kotlin + Ktor + Koin for dependency injection using hexagonal arch.

# Architecture

I decided to use hexagonal architecture to try to get the same order and control that one would usually
expect on a bigger application, using koin to decouple by injection on the layers.

# ex-ktor - module

Module in charge of starting the application, and also the "coordinator" between the layers, 
it inherits most of the dependencies from infrastructure and application layers. Also is where
I plan on putting the Integration + feature tests using Karate in the future (TODO).

Also, here is the place to maintain the dependency injection for koan (could be extracted from the main application class)

# ex-infrastructure - module

Module in charge of retaining all ktor configuration, like routings and plugins, this also is the place
where the outer layers of the application should be. For example, databases implementations should be done here while
respecting the domain contract (if there would be domain repositories to implement or not), rest, grpc, event layer could also live here.

# ex-application - module

Module in charge of retaining the application business logic, implements use cases from the domain and can be injected this way on the
infrastructure layer to complement. Exception management could also live here.

# ex-domain - module

Module in charge of retaining the domain of the application, all the domain logic is selfcontained here, 
the same applies to the use cases exposed to the outside, some logic that work directly on the domain could be done here. 
Also, some domain services could live here if needed.


## Small notes

I plan to keep working on this as I grasp a feeling on how is it to work with Ktor, but feel free to use in case you find it useful :).