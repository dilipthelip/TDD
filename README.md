# TDD

This tutorial is about TDD and uses different frameworks to use TDD.

## Mockito

Mockito is a framework which can be used to mock the implementation and write test cases around it.

### Test Class:

In order to automatically create the instances of the Mocked Objects it is mandatory to use **@RunWith(MockitoJUnitRunner.class)** at the top of the class as given below.


```
@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    ItemDao daoMock;

    @InjectMocks
    private ItemService service;

```

### Stubbing Method Calls:
