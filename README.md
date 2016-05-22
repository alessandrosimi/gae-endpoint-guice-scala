# Google App Engine with Guice and Google Endpoints

This is an empty project to start an Google App Engine application with Guice and Google Endpoints.

The project contains an example of endpoint a greeting API with tests.

The test coverage of the project is **100%**.

All the project is written in **Scala**.

## Usage

Create an google endpoint API (using the @Api annotation)

    @Api
    class MyApi {

        @ApiMethod
        def getSomething() ...

    }

Bind this api into a module so it would be initialized at start up.

    bind(classOf[MyApi]).in(Scopes.SINGLETON)

This will allow to inject any component into the API.

    @Api
    class MyApi @Inject() (component: Component) { ... }

The api can be easily injected into tests.

    class MyTest @Inject() (myApi: MyApi) extends AbstractTest {

        @Test
        def checkIfTheApiDoesSomething() {
            val result = myApi.getSomething
            assertEquals(expectedResult, result)
        }

    }

# Configure

Set the application name, changing the appengine-web.xml file.

    <application>my-app-engine-project</application>

The name to add is the google app engine project name.

# Run

To deploy this project on Google App Engine run the following command

mvn clean compile -U appengine:update